package com.devsuperior.bkcatalogo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/*
 * A annotation @Service serve para registrar a classe como um componente que vai participar do sistema 
 * de injetão de dependências automatizado do Spring, ou seja quem irá gerenciar as instâncias das dependencias
 * dos objetos do tipo CategoryService vai ser o Spring.Todo framework moderno tem algum mecanismo de injeção de 
 * dependências automatizado.
 */
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.bkcatalogo.dto.CategoryDTO;
import com.devsuperior.bkcatalogo.entities.Category;
import com.devsuperior.bkcatalogo.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;

	@Transactional(readOnly = true)
	public List<CategoryDTO> findAll() {
		List<Category> list = repository.findAll();

		return list.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());

		/*
		 * List<CategoryDTO> listDTO = new ArrayList<>(); for(Category cat : list ) {
		 * listDTO.add(new CategoryDTO(cat));
		 * 
		 */

	}
	@Transactional(readOnly = true)
	public CategoryDTO findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		Category entity = obj.get();
		return  new CategoryDTO(entity);
	}
	

}
