package com.vencimientos.back.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vencimientos.back.entity.Vencimiento;

@Repository
public interface VencimientoDao extends JpaRepository<Vencimiento, UUID> {

}
