package org.sid.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
@Entity
@Data
public class Profil implements Serializable{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProfil;
	private String  telephone;
	private String description;
	private String photo;
	
	@OneToMany(mappedBy = "profil",fetch = FetchType.LAZY)
	private List<RS> rs; 
	public Profil(String telephone, String description, String photo) {
		super();
		this.telephone = telephone;
		this.description = description;
		this.photo = photo;
		
		rs= new ArrayList();
	}
	public Profil() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
