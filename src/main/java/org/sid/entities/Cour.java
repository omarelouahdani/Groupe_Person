package org.sid.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;

@Entity
@Data
public class Cour implements Serializable {

	@Id @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long idCour;
	private String title;
	private String auteur;
	
	@Column(name = "name")
    @JsonView(View.FileInfo.class)
	private String name;
    
    @Column(name = "mimetype")
	private String mimetype;
	
	@Lob
    @Column(name="pic")
    private byte[] pic;
	
	
	@ManyToOne
	@JoinColumn(name = "id_type")
	private TypeCour type;
	
	
	public Cour(String title, String auteur) {
		
		this.title = title;
		this.auteur = auteur;
	}
	public Cour() {
		
	}
	
	public Cour(String title, String auteur, String name, String mimetype, byte[] pic) {
		super();
		this.title = title;
		this.auteur = auteur;
		this.name = name;
		this.mimetype = mimetype;
		this.pic = pic;
	}
	
	public Cour(String title,String auteur, TypeCour type) {
		super();
		this.title = title;
		this.auteur = auteur;
		this.type = type;
	}
	
	public Cour(String title, String auteur, String name, String mimetype, byte[] pic, TypeCour type) {
		super();
		this.title = title;
		this.auteur = auteur;
		this.name = name;
		this.mimetype = mimetype;
		this.pic = pic;
		this.type = type;
	}


	

	
	
	
	
	
	
}
