package com.devsuperior.bkcatalogo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/*
 * A annotation @Service serve para registrar a classe como um componente que vai participar do sistema 
 * de injetão de dependências automatizado do Spring, ou seja quem irá gerenciar as instâncias das dependencias
 * dos objetos do tipo CategoryService vai ser o Spring.Todo framework moderno tem algum mecanismo de injeção de 
 * dependências automatizado.
 */

import com.devsuperior.bkcatalogo.entities.Category;
import com.devsuperior.bkcatalogo.repositories.CategoryRepository;


@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	public List<Category>findAll(){
		return repository.findAll();
		
		
	}

}
