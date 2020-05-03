package org.sid.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.sid.dao.*;
import org.sid.entities.*;


@Controller
public class PromoControler {
	@Autowired
	ProfilRepository profileRepository;
	@Autowired
	UtilisateurRepository utilisateurRepository;
	@Autowired 
	RSRepository rsReppository;
	@Autowired
	LoginRepository loginRepository;
	@Autowired
	FiliereRepository filiereRepository;
	@Autowired
	PromoRepository promoRepository;
	
	
	@GetMapping(path = "/user/promo")
    public String profil(Model model ,@RequestParam(name = "nom",defaultValue = "") String  nom) {
		
    Filiere filiere     = filiereRepository.findByNom(nom);
    
    List<Promo> ps  =  promoRepository.findByid_Filiere(filiere.getIdFiliere());

	model.addAttribute("filiere", filiere);
	model.addAttribute("promos", ps);
	return "/user/Promo";

	
	}
	@GetMapping(path = "/user/filierePromo")
    public String profil(Model model ,@RequestParam(name = "filiere",defaultValue = "") String  nom,@RequestParam(name = "promo",defaultValue = "") long  id_promo) {
		Filiere filiere     = filiereRepository.findByNom(nom);
	    
	    List<Promo> ps  =  promoRepository.findByid_Filiere(filiere.getIdFiliere());
	    List<Utilisateur> utls  =  utilisateurRepository.findByid_Promo(id_promo,nom);
	
		model.addAttribute("filiere", filiere);
		model.addAttribute("promos", ps);
		model.addAttribute("utilisateurs", utls);

	return "/user/PromoEleve";

	
	}
}
