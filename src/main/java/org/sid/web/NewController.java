package org.sid.web;

import java.io.IOException;
import java.util.List;

import org.sid.entities.New;
import org.sid.service.NewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class NewController {
	
	@Autowired private NewService newService;
	
	@PostMapping("/news")
	public New save(@RequestParam("title") String title,
			        @RequestParam("description") String description,
			        @RequestParam("image",required = false) MultipartFile image,
			        @RequestParam("categorie") String categorie,
			        @RequestParam("author") String author) throws IOException {
		
		New n = new New();
		n.setTitle(title);
		n.setDescription(description);
		n.setCategorie(categorie);
		if(image!=null)
		n.setImage(image.getBytes());
		n.setAuthor(author);
		n = newService.save(n);
		n.setImageUrl(ServletUriComponentsBuilder
	                  .fromCurrentContextPath()
	                  .path("/news/image/")
	                  .path(n.get_id())
	                  .toUriString());
		return newService.save(n);
	}

	@GetMapping("/news")
	public List<New> getAll(){
		return  newService.getAll();
	}
	
	@GetMapping("/news/categorie/{categorie}")
	public List<New> getByCategorie(@PathVariable String categorie){
		return  newService.getByCategorie(categorie);
	}
	
	@GetMapping("/news/{id}")
	public New getOne(@PathVariable String id) {
		return  newService.getOne(id);
	}
	
	@DeleteMapping("/news/{id}")
	public void delete(@PathVariable String id) {
		newService.delete(id);
	}
	
	@GetMapping("/news/image/{id}")
	public ResponseEntity<byte[]> getImage(@PathVariable String id) throws IOException{
		New n = newService.getOne(id);

	    return ResponseEntity.ok()
	    		             .contentType(MediaType.IMAGE_PNG)
	                         .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + "news" + "\"")
	                         .body(n.getImage());
	  }
	

}
