package com.bitaka.pfe.model.DemandeConge;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.bitaka.pfe.model.Utilisateur;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "demandeConge")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DemandeConge {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDemandeConge;
	
    @Column(length = 50)
    private String regimeHoraire;

    @Temporal(TemporalType.DATE)
    @Column(name = "dateDernierJrsTravaille", nullable = false)
    private Date dateDernierJrsTravaille;

    @Temporal(TemporalType.DATE)
    @Column(name = "dateReprise", nullable = false)
    private Date dateReprise;

    @Column(length = 5)
    private int nbrJrsConge;

    @Column(length = 255)
    private String avalResponsable;

    @Column(length = 255)
    private int nbrJrsPris;

    @Column(length = 255)
    private int nbrJrsSansSolde;

    @Column(length = 255)
    private int nbrJrsRestant;
    
    @Column(length = 50)
    private Date dateCreation;

    @Column(length = 50)
    private Date dateModification;
  
    @Temporal(TemporalType.DATE)
    @Column(name = "dateValidation")
    private Date dateValidation;

    @Column(length = 255)
    private Boolean etat;
    
    @ManyToOne
    private Utilisateur utilisateur;
    
    @OneToMany(mappedBy = "demandeConge",cascade= {CascadeType.MERGE, CascadeType.PERSIST},fetch = FetchType.EAGER)
    private List<PorteuseWFLDC> PorteuseWFLDCs;
    

    
  /*  public void setIdDemandeConge(Long id) {
        this.idDemandeConge = id;
    }

    public Long getIdDemandeConge() {
        return this.idDemandeConge;
    }*/
	
	

}
