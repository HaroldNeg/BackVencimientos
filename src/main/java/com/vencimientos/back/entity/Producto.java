package com.vencimientos.back.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "productos")
public class Producto implements Serializable {
	
	private static final long serialVersionUID = 4755942277867097195L;
	
	@Id
	@GeneratedValue
	@Column(length = 16)
	private UUID id;
	
	@Column(length = 30, nullable = false)
	private String nombre;
	
	private String img;
}
