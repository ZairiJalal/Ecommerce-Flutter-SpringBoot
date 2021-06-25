package org.sid.web;

import java.util.List;

import org.sid.entities.AppUser;
import org.sid.service.AppUserService;
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
public class AppUserController {
	
	@Autowired private AppUserService appUserService;
	
	@PostMapping("/users")
	public AppUser save(@RequestBody AppUser u) {
		return appUserService.save(u);
	}
	
	@GetMapping("/users")
	public List<AppUser> getAll(){
		return  appUserService.getAll();
	}
	
	@GetMapping("/users/{id}")
	public AppUser getOne(@PathVariable String id) {
		return  appUserService.getOne(id);
	}
	
	@DeleteMapping("/users/{id}")
	public void delete(@PathVariable String id) {
		appUserService.delete(id);
	}

}
