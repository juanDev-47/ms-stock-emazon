package com.emazon.ms_stock.infraestructure.output.jpa.mySQL.repository;

import com.emazon.ms_stock.infraestructure.output.jpa.mySQL.Entity.BrandEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IBrandRepository extends JpaRepository<BrandEntity, Long> {
    Optional<BrandEntity> findBrandEntitiesByName(String name);
    Page<BrandEntity> findAll(Pageable pagination);
}
