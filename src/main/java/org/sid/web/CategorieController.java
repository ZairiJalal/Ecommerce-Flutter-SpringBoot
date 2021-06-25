package org.sid.web;

import java.util.List;

import org.sid.entities.Categorie;
import org.sid.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategorieController {
	

	@Autowired private CategorieService categorieService;
	
	@PostMapping("/categories")
	public Categorie save(@RequestBody Categorie c) {
		return categorieService.save(c);
	}
	
	@GetMapping("/categories")
	public List<Categorie> getAll(){
		return  categorieService.getAll();
	}
	
	@GetMapping("/categories/{id}")
	public Categorie getOne(@PathVariable String id) {
		return  categorieService.getOne(id);
	}
	
	@DeleteMapping("/categories/{id}")
	public void delete(@PathVariable String id) {
		categorieService.delete(id);
	}

}
