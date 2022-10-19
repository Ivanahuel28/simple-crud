package io.bootify.simple_crud;

import io.bootify.simple_crud.domain.Article;
import io.bootify.simple_crud.model.ArticleDTO;
import io.bootify.simple_crud.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @GetMapping("/")
    public String index() {
        return "Simple CRUD";
    }

    // GET ALL
    @GetMapping("/articles")
    public List<Article> getAllArticles() {
        return articleService.getAllArticles();
    }

    // GET ONE
    @GetMapping("/api/articles/{code}")
    public Article getArticle(@PathVariable("code") Long code) {
        return articleService.getArticleByCode(code);
    }

    // DELETE ONE
    @DeleteMapping("/api/articles/{code}")
    public void deleteArticle(@PathVariable("code") Long code) {
        articleService.delete(code);
    }

    // SAVE ONE
    @PostMapping("/api/articles")
    public int saveArticle(@RequestBody ArticleDTO dto) {
        articleService.update(dto);
        return Math.toIntExact(dto.getCode());
    }

    // REMOVE ONE
    @PutMapping("/api/articles")
    public Article update(@RequestBody Article article) {
        articleService.update(article);
        return article;
    }

}
