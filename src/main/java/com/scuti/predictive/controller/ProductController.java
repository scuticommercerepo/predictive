package com.scuti.predictive.controller;

import com.scuti.predictive.model.Product;
import com.scuti.predictive.repository.ProductMongoRepository;
import com.scuti.predictive.repository.ProductSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

	@Autowired
	ProductMongoRepository productMongoRepository;
	
	@Autowired
	ProductSearchRepository productSearchRepository;
	
	@RequestMapping("/home")
	public String home(Model model) {
		model.addAttribute("productList", productMongoRepository.findAll());
		return "home";
	}
	
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute Product product) {
		productMongoRepository.save(product);
		return "redirect:home";
	}
	
	@RequestMapping(value = "/search")
	public String search(Model model, @RequestParam String search) {
		model.addAttribute("productList", productSearchRepository.searchProduct(search));
		model.addAttribute("search", search);
		return "home";
	}
	
}
