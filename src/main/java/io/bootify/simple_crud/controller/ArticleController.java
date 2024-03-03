package io.bootify.simple_crud.controller;

import io.bootify.simple_crud.domain.Article;
import io.bootify.simple_crud.model.ArticleDTO;
import io.bootify.simple_crud.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleController {

    ArticleService articleService;

    @GetMapping("/articles")
    public List<Article> getAllArticles() {
        return articleService.getAllArticles();
    }

    @GetMapping("/api/articles/{code}")
    public Article getArticle(@PathVariable("code") Long code) {
        return articleService.getArticleByCode(code);
    }

    @DeleteMapping("/api/articles/{code}")
    public void deleteArticle(@PathVariable("code") Long code) {
        articleService.delete(code);
    }

    @PostMapping("/api/articles")
    public int saveArticle(@RequestBody ArticleDTO dto) {
        articleService.update(dto);
        return Math.toIntExact(dto.getCode());
    }

    @PutMapping("/api/articles")
    public void update(@RequestBody ArticleDTO dto) {
        articleService.delete(dto.getCode());
    }


    @Autowired
    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }
}
