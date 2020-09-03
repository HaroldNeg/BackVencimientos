package com.vencimientos.back.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vencimientos.back.entity.Producto;
import com.vencimientos.back.service.ProductoService;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	private ProductoService service;

	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Producto entity){
		service.create(entity);
		return ResponseEntity.status(201).build();
	}
	
	@GetMapping
	public ResponseEntity<?> listar(Pageable pageable){
		List<Producto> list = service.read(pageable);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> detallar(@PathVariable String id){
		Optional<Producto> op = service.read(UUID.fromString(id));
		if (op.isPresent()) {
			return ResponseEntity.ok(op.get());
		}
			return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> detallar(@PathVariable String id, @RequestBody Producto entity){
		service.update(UUID.fromString(id), entity);
		return ResponseEntity.status(204).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable String id){
		service.delete(UUID.fromString(id));
		return ResponseEntity.status(204).build();
	}
}
