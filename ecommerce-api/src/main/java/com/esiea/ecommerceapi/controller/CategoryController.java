package com.esiea.ecommerceapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esiea.ecommerceapi.model.Category;
import com.esiea.ecommerceapi.service.CategoryService;
import com.esiea.ecommerceapi.service.NotFoundException;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/private/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("")
	public Iterable<Category> getCategories() {
		return categoryService.getCategories();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Category> getProduct(@PathVariable("id") Long id) {
		try {
			Category p = categoryService.getCategory(id);
			return new ResponseEntity<Category>(p, HttpStatus.OK);
		} catch (NotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<Category> getCategoryByName(@PathVariable("name") String name) {
		try {
			Category p = categoryService.getProductByName(name);
			return new ResponseEntity<Category>(p, HttpStatus.OK);
		} catch (NotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
	
	@PostMapping("")
	public Category createCategory(@RequestBody Category category) {
		return categoryService.create(category);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCategory(@PathVariable("id")Long id) {
		categoryService.deleteCategory(id);
	}
	
	@PutMapping("")
	public Category replaceCategory(@RequestBody Category category) {
		return categoryService.update(category);
	}
	
	@PatchMapping("")
	public ResponseEntity<Category> partialReplaceCategory(@RequestBody Category category){
		try {
			Category existingCategory = categoryService.getCategory(category.getId());
			if(category.getName() != null && !category.getName().equals(existingCategory.getName())) {
				existingCategory.setName(category.getName());
			}
			existingCategory = categoryService.update(existingCategory);
			return new ResponseEntity<Category>(existingCategory, HttpStatus.OK);
		}
		catch(NotFoundException e){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
