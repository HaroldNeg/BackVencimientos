package com.vencimientos.back.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vencimientos.back.entity.Producto;
import com.vencimientos.back.repository.ProductoDao;
import com.vencimientos.back.service.ProductoService;

@Service
@Transactional
public class ProductoServiceImpl implements ProductoService {
	
	@Autowired
	private ProductoDao dao;

	@Override
	public void create(Producto entity) {
		dao.save(entity);
	}

	@Override
	public List<Producto> read(Pageable pageable) {
		Order order = new Order(Direction.ASC, "nombre");
		List<Order> orders = new ArrayList<>();
		orders.add(order);
		Sort sort = Sort.by(orders);
		return dao.findAll(sort);
		//return dao.findAll(pageable).toList();
	}

	@Override
	public Optional<Producto> read(UUID id) {
		return dao.findById(id);
	}

	@Override
	public void update(UUID id, Producto entity) {
				
	}

	@Override
	public void delete(UUID id) {
		dao.deleteById(id);		
	}

	@Override
	public long count(Pageable pageable) {
		return dao.count();
	}

	
}
