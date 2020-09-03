package com.vencimientos.back.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Pageable;

import com.vencimientos.back.entity.Vencimiento;

public interface VencimientoService {

	public abstract void create(Vencimiento entity);
	
	public abstract List<Vencimiento> read(Pageable pageable);
	
	public abstract Optional<Vencimiento> read(UUID id);
	
	public abstract void update(UUID id, Vencimiento entity);
	
	public abstract void delete(UUID id);
	
	public abstract long count();
}
