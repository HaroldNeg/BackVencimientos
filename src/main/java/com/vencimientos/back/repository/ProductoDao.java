package com.vencimientos.back.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vencimientos.back.entity.Producto;

@Repository
public interface ProductoDao extends JpaRepository<Producto, UUID> {
}
