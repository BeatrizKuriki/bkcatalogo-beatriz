package com.devsuperior.bkcatalogo.services;


import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
/*
 * A annotation @Service serve para registrar a classe como um componente que vai participar do sistema 
 * de injetão de dependências automatizado do Spring, ou seja quem irá gerenciar as instâncias das dependencias
 * dos objetos do tipo ProductService vai ser o Spring.Todo framework moderno tem algum mecanismo de injeção de 
 * dependências automatizado.
 */
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.bkcatalogo.dto.CategoryDTO;
import com.devsuperior.bkcatalogo.dto.ProductDTO;
import com.devsuperior.bkcatalogo.entities.Category;
import com.devsuperior.bkcatalogo.entities.Product;
import com.devsuperior.bkcatalogo.repositories.CategoryRepository;
import com.devsuperior.bkcatalogo.repositories.ProductRepository;
import com.devsuperior.bkcatalogo.services.exceptions.DataBaseException;
import com.devsuperior.bkcatalogo.services.exceptions.ResourceNotFoundException;



@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	@Autowired
	private CategoryRepository categoryRepository;

	@Transactional(readOnly = true)
	public Page<ProductDTO> findAllPaged(PageRequest pageResquest) {
		Page<Product> list = repository.findAll(pageResquest);

		return list.map(x -> new ProductDTO(x));

		/*
		 * List<ProductDTO> listDTO = new ArrayList<>(); for(Product cat : list ) {
		 * listDTO.add(new ProductDTO(cat));
		 * 
		 */

	}
	@Transactional(readOnly = true)
	public ProductDTO findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		Product entity = obj.orElseThrow(()-> new ResourceNotFoundException("Entity not found"));
		return  new ProductDTO(entity, entity.getCategories());
	}
	@Transactional
	public ProductDTO insert(ProductDTO dto) {
		Product entity = new Product();
		copyDtoToEntity(dto, entity);
		//entity.setName(dto.getName());
		entity = repository.save(entity);
		return new ProductDTO(entity);
	}
	
	@Transactional
	public ProductDTO update(Long id, ProductDTO dto) {	
		try {
		Product entity = repository.getOne(id);
		copyDtoToEntity(dto, entity);
		//entity.setName(dto.getName());
		entity = repository.save(entity);
		return new ProductDTO(entity);
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not Found" + id);
			
		}
		
	
	}
	
	public void delete(Long id) {
		try {
		repository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found "+id);
		}
		
		catch(DataIntegrityViolationException e) {
			throw new DataBaseException ("Integrity violation.");
		}
		}
		private void copyDtoToEntity(ProductDTO dto, Product entity) {
			entity.setName(dto.getName());
			entity.setDescription(dto.getDescription());
			entity.setDate(dto.getDate());
			entity.setImgUrl(dto.getImgUrl());
			entity.setPrice(dto.getPrice());
			
			entity.getCategories().clear();
			for(CategoryDTO catDto : dto.getCategories()) {
				Category category = categoryRepository.getOne(catDto.getId());
				entity.getCategories().add(category);
		}
			
			
			
			
		
		
	}
	

}
