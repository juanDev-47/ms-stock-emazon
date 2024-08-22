package com.emazon.ms_stock.infraestructure.output.jpa.mySQL.repository;

import com.emazon.ms_stock.infraestructure.output.jpa.mySQL.Entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICategoryRepository extends JpaRepository<CategoryEntity, Long> {
    Optional<CategoryEntity> findCategoryEntitiesByName(String name);
}
