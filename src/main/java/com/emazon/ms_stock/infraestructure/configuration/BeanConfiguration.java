package com.emazon.ms_stock.infraestructure.configuration;

import com.emazon.ms_stock.domain.api.IArticleServicePort;
import com.emazon.ms_stock.domain.api.IBrandServicePort;
import com.emazon.ms_stock.domain.api.ICategoryServicePort;
import com.emazon.ms_stock.domain.spi.IArticlePersistencePort;
import com.emazon.ms_stock.domain.spi.IBrandPersistencePort;
import com.emazon.ms_stock.domain.spi.ICategoryPersistencePort;
import com.emazon.ms_stock.domain.useCase.ArticleUseCase;
import com.emazon.ms_stock.domain.useCase.BrandUseCase;
import com.emazon.ms_stock.domain.useCase.CategoryUseCase;
import com.emazon.ms_stock.infraestructure.output.jpa.mySQL.Mapper.ArticleEntityMapper;
import com.emazon.ms_stock.infraestructure.output.jpa.mySQL.Mapper.BrandEntityMapper;
import com.emazon.ms_stock.infraestructure.output.jpa.mySQL.Mapper.CategoryEntityMapper;
import com.emazon.ms_stock.infraestructure.output.jpa.mySQL.adapter.ArticleJpaAdapter;
import com.emazon.ms_stock.infraestructure.output.jpa.mySQL.adapter.BrandJpaAdapter;
import com.emazon.ms_stock.infraestructure.output.jpa.mySQL.adapter.CategoryJpaAdapter;
import com.emazon.ms_stock.infraestructure.output.jpa.mySQL.repository.IArticleRepository;
import com.emazon.ms_stock.infraestructure.output.jpa.mySQL.repository.IBrandRepository;
import com.emazon.ms_stock.infraestructure.output.jpa.mySQL.repository.ICategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final IArticleRepository articleRepository;
    private final IBrandRepository brandRepository;
    private final ICategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;
    private final BrandEntityMapper brandEntityMapper;
    private final ArticleEntityMapper articleEntityMapper;

    @Bean
    public IArticlePersistencePort articlePersistencePort(){
        return new ArticleJpaAdapter(articleEntityMapper, articleRepository);
    }

    @Bean
    public IArticleServicePort articleServicePort() {
        return new ArticleUseCase(articlePersistencePort());
    }

    @Bean
    public IBrandPersistencePort brandPersistencePort(){
        return new BrandJpaAdapter(brandEntityMapper, brandRepository);
    }

    @Bean
    public IBrandServicePort brandServicePort(){
        return new BrandUseCase(brandPersistencePort());
    }

    @Bean
    public ICategoryPersistencePort categoryPersistencePort(){
        return new CategoryJpaAdapter(categoryEntityMapper, categoryRepository);
    }

    @Bean
    public ICategoryServicePort categoryServicePort(){
        return new CategoryUseCase(categoryPersistencePort());
    }

}
