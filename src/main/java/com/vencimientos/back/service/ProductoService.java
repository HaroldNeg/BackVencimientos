package com.vencimientos.back.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Pageable;

import com.vencimientos.back.entity.Producto;

public interface ProductoService {

	public abstract void create(Producto entity);
	
	public abstract List<Producto> read(Pageable pageable);
	
	public abstract Optional<Producto> read(UUID id);
	
	public abstract void update(UUID id, Producto entity);
	
	public abstract void delete(UUID id);
	
	public abstract long count(Pageable pageable);
}
