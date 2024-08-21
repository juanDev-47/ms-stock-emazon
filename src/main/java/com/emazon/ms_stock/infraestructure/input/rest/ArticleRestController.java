package com.emazon.ms_stock.infraestructure.input.rest;

import com.emazon.ms_stock.application.dto.ArticleRequest;
import com.emazon.ms_stock.application.dto.ArticleResponse;
import com.emazon.ms_stock.application.handler.IArticleHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article/")
@RequiredArgsConstructor
public class ArticleRestController {
    private final IArticleHandler articleHandler;

    @PostMapping
    public ResponseEntity<Void> saveArticle(@RequestBody ArticleRequest articleRequest){
        articleHandler.saveArticle(articleRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<ArticleResponse>> getAllArticles() {
        return ResponseEntity.ok(articleHandler.getAllArticle());
    }

    @GetMapping("{id}")
    public ResponseEntity<ArticleResponse> getArticle(@PathVariable Long id){
        return ResponseEntity.ok(articleHandler.getArticle(id));
    }

    @PutMapping
    public ResponseEntity<Void> updateArticle(@RequestBody ArticleRequest articleRequest) {
        articleHandler.updateArticle(articleRequest);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id){
        articleHandler.deleteArticle(id);
        return ResponseEntity.noContent().build();
    }

}
