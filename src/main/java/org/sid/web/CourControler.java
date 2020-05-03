package org.sid.web;

import java.util.List;

import org.sid.entities.Profil;
import org.sid.entities.RS;
import org.sid.entities.Utilisateur;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CourControler {

	
	@GetMapping(path = "/cour")
    public String edit(Model model) {
	   
	   
		return "/user/cour";
    }
	
}
