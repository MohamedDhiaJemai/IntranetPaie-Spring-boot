package com.bitaka.pfe.model.DemandeConge;

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

import com.bitaka.pfe.model.Centre;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class WorkFlowDC {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idWorkFlowDC;

    @Temporal(TemporalType.DATE)
    @Column(name = "dateDebutActivation", nullable = false)
    private Date dateDebutActivation;

    @Temporal(TemporalType.DATE)
    @Column(name = "dateFinActivation", nullable = false)
    private Date dateFinActivation;

    @Column(length = 50)
    private Boolean activation;
    
    
    @OneToMany(mappedBy = "workFlowDC",cascade= {CascadeType.MERGE, CascadeType.PERSIST})
    List<PorteuseWFLDCRole> porteuseWFLDCRoles;

    @OneToMany(mappedBy = "workFlowDC")
    private List<PorteuseWFLDC> porteuseWFLDCs;

    @ManyToOne
    private Centre centre;

}
