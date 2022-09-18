package com.devsuperior.bkcatalogo.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;


//Serializable é um padrao da linguagem java para que o obj java possa ser convertido em bytes
//com Serializable o objeto pode ser gravado em arquivos, passa nas redes(**prática muito importante)

@Entity
@Table(name = "tb_category")
public class Category implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	
	/*
	 * SEMPRE QUE FOR ARMAZENAR DADOS QUE PRECISAM DE HORAS E DATAS DÊ PREFERÊNCIA PARA TIMEZONE UTC E DEPOIS TRATE A RESPOSTA DE ACORDO
	 * COM O LOCAL EM QUE O SERVIÇO SERÁ PRESTADO OU EXIBIDO.
	 */
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant creatAt;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant updateAt;
	
	
	
	public Instant getUpdateAt() {
		return updateAt;
	}



	public Instant getCreatAt() {
		return creatAt;
	}
	

	@PrePersist
	public void prePersist() {
		creatAt = Instant.now();
	}
	
	@PreUpdate
	public void preUpdate() {
		updateAt = Instant.now();
	}
	

	

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
