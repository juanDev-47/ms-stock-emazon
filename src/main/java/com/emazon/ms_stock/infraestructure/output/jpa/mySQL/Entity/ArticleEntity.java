package com.emazon.ms_stock.infraestructure.output.jpa.mySQL.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "article")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ArticleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Integer amount;
    private BigDecimal price;

    @ManyToMany
    @JoinTable(name = "article_category", joinColumns = @JoinColumn(name = "id_article"), inverseJoinColumns = @JoinColumn(name = "id_category"))
    private Set<CategoryEntity> categories = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "id_brand")
    private BrandEntity brand;
}
