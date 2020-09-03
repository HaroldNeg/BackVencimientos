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

import com.vencimientos.back.entity.Vencimiento;
import com.vencimientos.back.repository.VencimientoDao;
import com.vencimientos.back.service.VencimientoService;

@Service
@Transactional
public class VencimientoServiceImpl implements VencimientoService {
	
	@Autowired
	private VencimientoDao dao;

	@Override
	public void create(Vencimiento entity) {
		dao.save(entity);

	}

	@Override
	public List<Vencimiento> read(Pageable pageable) {
		Order order = new Order(Direction.DESC, "fecha");
		List<Order> orders = new ArrayList<>();
		orders.add(order);
		Sort sort = Sort.by(orders);
		return dao.findAll(sort);
		//return dao.findAll(pageable).toList();
	}

	@Override
	public Optional<Vencimiento> read(UUID id) {
		return dao.findById(id);
	}

	@Override
	public void update(UUID id, Vencimiento entity) {
		if (dao.findById(id).isPresent()) {
			entity.setId(id);
			create(entity);
		} 
	}

	@Override
	public void delete(UUID id) {
		dao.deleteById(id);
	}

	@Override
	public long count() {
		return dao.count();
	}

}
