package io.bootify.simple_crud.service;

import io.bootify.simple_crud.domain.Article;
import io.bootify.simple_crud.model.ArticleDTO;
import io.bootify.simple_crud.repos.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ArticleService {

    private ArticleRepository articleRepository;

    public List<Article> getAllArticles() {
        return new ArrayList<>(articleRepository.findAll());
    }

    public List<ArticleDTO> findAll() {
        return articleRepository.findAll(Sort.by("code"))
                .stream()
                .map(article -> mapToDTO(article, new ArticleDTO()))
                .toList();
    }

    public ArticleDTO get(final Long code) {
        return articleRepository.findById(code)
                .map(article -> mapToDTO(article, new ArticleDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Long create(final ArticleDTO articleDTO) {
        final Article article = new Article();
        mapToEntity(articleDTO, article);
        return articleRepository.save(article).getCode();
    }

    public void update(final ArticleDTO articleDTO) {
        final Article article = articleRepository.findById(articleDTO.getCode())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(articleDTO, article);
        articleRepository.save(article);
    }

    public void delete(final Long code) {
        articleRepository.deleteById(code);
    }

    private ArticleDTO mapToDTO(final Article article, final ArticleDTO articleDTO) {
        articleDTO.setCode(article.getCode());
        articleDTO.setDescription(article.getDescription());
        articleDTO.setPrice(article.getPrice());
        return articleDTO;
    }

    private Article mapToEntity(final ArticleDTO articleDTO, final Article article) {
        article.setDescription(articleDTO.getDescription());
        article.setPrice(articleDTO.getPrice());
        return article;
    }

    public Article getArticleByCode(Long code) {
        Optional<Article> article = articleRepository.findById(code);
        return article.isPresent() ? article.get() : null;
    }

    @Autowired
    public void setArticleRepository(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }
}
