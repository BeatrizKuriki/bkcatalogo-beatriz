package com.devsuperior.bkcatalogo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.bkcatalogo.dto.CategoryDTO;
import com.devsuperior.bkcatalogo.services.CategoryService;

/*
 * Sempre que um recurso tiver a ver com uma entidade a clase será nomeada com o nome da entidade 
 * mais a palavra Resource- como no caso dessa classe que se chama CategoryResources(sendo a entidade
 * a classe Category e o recurso a classe CategoryResource) que vai indicar que essa classe é um recurso
 * da entidade (no caso entidade Category)
 * Para configurar no Spring que está classe vai ser um controlador REST e vai responder requisições
 * nesse recurso, a gente colocar uma annotation chamada RestController
 * O annotation é uma forma enxuta e simples de você configurar alguma coisa no seu código
 * ao invés de ter de programar do zero vc usa algo que já está implementado
 * No Spring os programadores do framework já implementaram toda a infraestrutura necessária
 * para transformar uma classe em um recurso Rest/ essa annotation realiza um pré-processamento por 
 * baixo dos panos ao compilar a classe e ela será disponibilizada como recurso */


@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	
	// A classe Resource implementa o controlador Rest
	/*
	 * O backend vai disponibilizar uma API(Application Programming Interface)
	 * Como se o recurso fosse um conceito e o controlador a forma de implementar esse conceito
	 * ABAIXO SERÁ CRIADO O PRIMEIRO ENDPOINT- PRIMEIRA ROTA POSSÍVEL QUE VAI RESPONDER ALGUMA COISA
	 */
	
	@Autowired
	private CategoryService service;
	@GetMapping
	public ResponseEntity<List<CategoryDTO>> findAll(){
		List<CategoryDTO> list = service.findAll();		
		return ResponseEntity.ok().body(list);
		
	}

}
