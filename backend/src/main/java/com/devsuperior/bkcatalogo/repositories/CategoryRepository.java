package com.devsuperior.bkcatalogo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.bkcatalogo.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
	
	

}


