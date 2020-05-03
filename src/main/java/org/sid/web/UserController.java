package org.sid.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.sid.dao.*;
import  org.sid.entities.*;
@Controller
public class UserController {
	@Autowired
	private ArticleRepository articledao;
	@Autowired 
	private UtilisateurRepository userdao;
	@Autowired
	private FiliereRepository filiereRepository;
	private Long id_user = (long) 1;

	@GetMapping("/user/articles")
	public String articles(Model model) {
		List<Article> articles = articledao.findAll();
		Article article = new Article();
		Utilisateur user = userdao.getOne(id_user);
		article.setUser(user);
		model.addAttribute("article", article);
		model.addAttribute("articles", articles);
		model.addAttribute("filieres", filiereRepository.findAll());
		return "/user/ArticlePage";
	}
	
	@GetMapping("/user/articles/ArticleForm")
	public String formArticles(Model model) {
		Article article = new Article();
		Utilisateur user = userdao.getOne(id_user);
		article.setUser(user);
		model.addAttribute("article", article);
		return "/user/FormArticle";
	}
	
	@RequestMapping(value = "/user/articles/save", method = RequestMethod.POST)
	public String saveArticle(Model model,@Valid Article article, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "FormArticle";
		articledao.save(article);
		return "redirect:/user/articles";
	}
	

}
