package org.sid;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sound.midi.Soundbank;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.sid.dao.AdminRepository;
import org.sid.dao.CourRepository;
import org.sid.dao.EcoleRepository;
import org.sid.dao.FiliereRepository;
import org.sid.dao.LoginRepository;
import org.sid.dao.ProfilRepository;
import org.sid.dao.PromoRepository;
import org.sid.dao.RSRepository;
import org.sid.dao.TypeCourRepisitory;
import org.sid.dao.UtilisateurRepository;
import org.sid.entities.Admin;
import org.sid.entities.Cour;
import org.sid.entities.Ecole;
import org.sid.entities.Filiere;
import org.sid.entities.Login;
import org.sid.entities.Profil;
import org.sid.entities.Promo;
import org.sid.entities.RS;
import org.sid.entities.TypeCour;
import org.sid.entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@SpringBootApplication
public class GroupePersonnelApplication  implements CommandLineRunner {

	@Autowired
	LoginRepository loginRepository;
	@Autowired
	AdminRepository adminRepository;
	@Autowired
	ProfilRepository profileRepository;
	@Autowired
	EcoleRepository ecoleRepository;
	@Autowired
	UtilisateurRepository utilisateurRepository;
	@Autowired
	RSRepository rsRepository;
	@Autowired
	FiliereRepository filierRepository;
	@Autowired
	PromoRepository promoRepository;
	@Autowired
	TypeCourRepisitory typeCourRepisitory;
	@Autowired
	CourRepository courRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(GroupePersonnelApplication.class, args);
		
		
	}
	@Override
	public void run(String... args) throws Exception {

		List<Cour> cours = courRepository.findByid_TypeCour((long)2);
	
		
        cours.forEach(e -> {
        
        	System.out.println(e.getAuteur());
        });
	   
	    	
	
		    	
		    	
	}	
    

}
