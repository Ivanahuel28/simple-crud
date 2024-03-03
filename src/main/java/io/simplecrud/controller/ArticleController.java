package io.simplecrud.controller;

import io.bootify.simple_crud.domain.Article;
import io.simplecrud.dtos.ArticleDTO;
import io.simplecrud.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController("article")
public class ArticleController {

    ArticleService articleService;
    
    @PostMapping
    public ResponseEntity create(@RequestBody ArticleDTO dto) {
        return ResponseEntity.of(Optional.of(articleService.create(dto)));
    }

    @GetMapping("{code}")
    public Article get(@PathVariable("code") Long code) {
        return articleService.getArticleByCode(code);
    }

    @PutMapping
    public void update(@RequestBody ArticleDTO dto) {
        articleService.update(dto.getCode());
    }

    @DeleteMapping("/api/articles/{code}")
    public void delete(@PathVariable("code") Long code) {
        articleService.delete(code);
    }

    @Autowired
    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }
}
