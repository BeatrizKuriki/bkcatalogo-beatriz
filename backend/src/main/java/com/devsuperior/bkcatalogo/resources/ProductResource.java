package com.devsuperior.bkcatalogo.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devsuperior.bkcatalogo.dto.ProductDTO;
import com.devsuperior.bkcatalogo.services.ProductService;

/*
 * Sempre que um recurso tiver a ver com uma entidade a clase será nomeada com o nome da entidade 
 * mais a palavra Resource- como no caso dessa classe que se chama ProductResources(sendo a entidade
 * a classe Product e o recurso a classe ProductResource) que vai indicar que essa classe é um recurso
 * da entidade (no caso entidade Product)
 * Para configurar no Spring que está classe vai ser um controlador REST e vai responder requisições
 * nesse recurso, a gente colocar uma annotation chamada RestController
 * O annotation é uma forma enxuta e simples de você configurar alguma coisa no seu código
 * ao invés de ter de programar do zero vc usa algo que já está implementado
 * No Spring os programadores do framework já implementaram toda a infraestrutura necessária
 * para transformar uma classe em um recurso Rest/ essa annotation realiza um pré-processamento por 
 * baixo dos panos ao compilar a classe e ela será disponibilizada como recurso */


@RestController
@RequestMapping(value = "/products")
public class ProductResource {
	
	// A classe Resource implementa o controlador Rest
	/*
	 * O backend vai disponibilizar uma API(Application Programming Interface)
	 * Como se o recurso fosse um conceito e o controlador a forma de implementar esse conceito
	 * ABAIXO SERÁ CRIADO O PRIMEIRO ENDPOINT- PRIMEIRA ROTA POSSÍVEL QUE VAI RESPONDER ALGUMA COISA
	 */
	
	@Autowired
	private ProductService service;
	
	@GetMapping
	public ResponseEntity<Page<ProductDTO>> findAll(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "ASC") String direction,
			@RequestParam(value = "direction", defaultValue = "name") String orderBy
			
			){
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderBy );
		
		
		Page<ProductDTO> list = service.findAllPaged(pageRequest);		
		return ResponseEntity.ok().body(list);
		
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<ProductDTO> findById(@PathVariable Long id){
		ProductDTO dto = service.findById(id);		
		return ResponseEntity.ok().body(dto);

}
	
	@PostMapping
	public ResponseEntity<ProductDTO> insert(@RequestBody ProductDTO dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
		
	}
	@PutMapping(value = "/{id}")
	public ResponseEntity<ProductDTO> update(@PathVariable Long id, @RequestBody ProductDTO dto){
		dto = service.update(id, dto);
		
		return ResponseEntity.ok().body(dto);
	
}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
}