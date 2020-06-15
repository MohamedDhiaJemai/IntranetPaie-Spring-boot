package com.bitaka.pfe.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Message {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMessage;
	
    @Column(name = "infos", nullable = false)
    private String infos;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "dateMessage", nullable = false)
    private Date dateMessage;
    
    @Temporal(TemporalType.TIME)
    @Column(name = "heureMessage", nullable = false)
    private Date heureMessage;
    
    private Boolean status;
    
    @ManyToOne
    private Utilisateur emetteur;

    @ManyToOne
    private Utilisateur recepteur;

}
