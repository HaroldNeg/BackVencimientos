package com.vencimientos.back.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "vencimientos")
public class Vencimiento implements Serializable {

	private static final long serialVersionUID = 7674209448367044632L;
	
	@Id
	@GeneratedValue
	@Column(length = 16)
	private UUID id;
	
	@Column(nullable = false, updatable = false)
	private LocalDate fecha;
	
	private int cant;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id", name = "productoId", nullable = false)
	private Producto producto;
}
