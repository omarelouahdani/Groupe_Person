package org.sid.web;

import java.util.List;



import org.sid.dao.CourRepository;
import org.sid.dao.TypeCourRepisitory;
import org.sid.entities.Cour;

import org.sid.entities.TypeCour;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CourControler {
   @Autowired
	TypeCourRepisitory typeCourRepisitory;
   @Autowired
   CourRepository courRepository;
	@GetMapping(path = "/user/cour")
    public String edit(Model model) {
	   
		List<TypeCour> crs   = typeCourRepisitory.findAll();
		model.addAttribute("coursType",crs);
		List<Cour> cours = courRepository.findAll();
		model.addAttribute("cours",cours);
		
		
		
		return "/user/PageCour";
    }
	@GetMapping(path = "/user/downloadFile")
    public ResponseEntity<ByteArrayResource> downloadFile(@RequestParam(name = "cour",defaultValue = "") long  id) {
	     Cour cour = courRepository.findById(id).get();
	     return ResponseEntity.ok()
	    		 .contentType(MediaType.parseMediaType(cour.getMimetype()))
	    		 .header(HttpHeaders.CONTENT_DISPOSITION,"attachement:filename=\""+cour.getName()+"\"")
	    		 .body(new ByteArrayResource(cour.getPic()));

		
		
		
    }
	
	
}
