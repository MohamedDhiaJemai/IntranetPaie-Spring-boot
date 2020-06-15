package com.bitaka.pfe;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.bitaka.pfe.model.Centre;
import com.bitaka.pfe.model.Role;
import com.bitaka.pfe.model.Utilisateur;
import com.bitaka.pfe.services.CentreService;
import com.bitaka.pfe.services.RoleService;
import com.bitaka.pfe.services.UtilisateurService;

@SpringBootApplication
public class PfeIntranetPaieApplication {

	public static void main(String[] args) {
		SpringApplication.run(PfeIntranetPaieApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder getBCPE() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner start(RoleService roleService, CentreService centreService, UtilisateurService userService) {
		return args -> {

			/*Role role1 = new Role(null, "admin", "des", null);
			roleService.addRole(role1);

			Centre centre1 = new Centre(null, "centre 1", "libelle", null);
			centreService.addCentre(centre1);

			Utilisateur user1 = new Utilisateur(null, "admin", "123456", "Ahmed", "Ben Ali", "97408105", "jemai@gmail.com", "idCCMS",
					"matricule", null, null);
			userService.addUser(user1);*/
			
		};
	}

}
