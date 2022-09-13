package com.devsuperior.bkcatalogo.entities;

import java.io.Serializable;
import java.util.Objects;


//Serializable é um padrao da linguagem java para que o obj java possa ser convertido em bytes
//com Serializable o objeto pode ser gravado em arquivos, passa nas redes(**prática muito importante)
public class Category implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	
	public Category() {
		
	}
	
	public Category(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return Objects.equals(id, other.id);
	}


	
	

}
