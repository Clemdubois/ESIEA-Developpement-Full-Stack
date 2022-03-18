package com.esiea.ecommerceapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esiea.ecommerceapi.model.Category;
import com.esiea.ecommerceapi.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public Iterable<Category> getCategories() {
		return categoryRepository.findAll();
	}
	
	public Iterable<Category> getCategory() {
		return categoryRepository.findAll();
	}
	
	public Category getCategory(Long id) throws NotFoundException{
		Optional<Category> result = categoryRepository.findById(id);
		if(result.isPresent()) {
			return result.get();
		}
		else {
			throw new NotFoundException();
		}
	}

	public Category create(Category category) {
		return categoryRepository.save(category);
	}
	

	public Category getProductByName(String name) throws NotFoundException {
		Optional<Category> result = categoryRepository.findByName(name);
		if(result.isPresent()) {
			return result.get();
		}
		else {
			throw new NotFoundException();
		}
	}

	public void deleteCategory(Long id) {
		categoryRepository.deleteById(id);
	}

	public Category update(Category category) {
		return categoryRepository.save(category);
	}
}
