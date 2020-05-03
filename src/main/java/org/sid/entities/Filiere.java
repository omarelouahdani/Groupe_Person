package org.sid.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
@Entity
@Data
public class Filiere  implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFiliere;
	private String nom;
	@ManyToOne
	@JoinColumn(name = "ID_departement")
	private Departement departement ;
	
	@OneToMany(mappedBy = "filiere",fetch = FetchType.LAZY)
	List<Utilisateur> users ;
	public Filiere() {
		// TODO Auto-generated constructor stub
	}
	public Filiere(Long id, String nom) {
		this.idFiliere = id;
		this.nom = nom;
	}
	
	public Filiere(String nom, Departement idDepartement) {
		this.nom = nom;
		this.departement = idDepartement;
		users = new ArrayList();
	}


	
	
}
