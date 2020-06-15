package com.bitaka.pfe.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JWTAuthorizationFiler extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		response.addHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers",
				"Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers,authorization");
		response.addHeader("Access-Control-Expose-Headers",
				"Access-Control-Allow-Origin, Access-Control-Allow-Credentials, authorization");

		if (request.getMethod().equals("OPTIONS")) {

			response.setStatus(HttpServletResponse.SC_OK);

		}

		else if (request.getRequestURI().equals("/login")) {

			filterChain.doFilter(request, response);

			return;
		}

		else {

			String jwtToken = request.getHeader(SecurityParams.JWT_HEADER_NAME);

			System.out.println("Token=" + jwtToken);

			if (jwtToken == null || !jwtToken.startsWith(SecurityParams.HEADER_PREFIX)) {

				System.out.println("Problem with Token");

				filterChain.doFilter(request, response);
				return;
			}

			System.out.println("TOKEN IS OK");

			Claims claims = Jwts.parser().setSigningKey(SecurityParams.SECRET)
					.parseClaimsJws(jwtToken.replace(SecurityParams.HEADER_PREFIX, "")).getBody();

			String username = claims.getSubject();

			ArrayList<Map<String, String>> roles = (ArrayList<Map<String, String>>) claims.get("roles");

			Collection<GrantedAuthority> authorities = new ArrayList<>();

			roles.forEach(r -> {
				authorities.add(new SimpleGrantedAuthority(r.get("authority")));
			});

			UsernamePasswordAuthenticationToken authenticatedUser = new UsernamePasswordAuthenticationToken(username,
					null, authorities);

			System.out.println("AUTORIZATION FILTER");
			System.out.println(authenticatedUser.getAuthorities());

			SecurityContextHolder.getContext().setAuthentication(authenticatedUser);

			filterChain.doFilter(request, response);
		}
	}
}