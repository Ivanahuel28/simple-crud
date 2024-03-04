package io.simplecrud.service;

import io.bootify.simple_crud.domain.Article;
import io.simplecrud.dtos.ArticleDTO;
import io.simplecrud.mapper.ArticleMapper;
import io.simplecrud.repos.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;


@Service
public class ArticleService {

    private ArticleRepository articleRepository;
    private ArticleMapper articleMapper;

    public ArticleDTO create(final ArticleDTO articleDTO) {
        return articleMapper.toDTO(articleRepository.save(articleMapper.toEntity(articleDTO)));
    }

    public Article getArticleByCode(Long code) {
        Optional<Article> article = articleRepository.findById(code);
        return article.isPresent() ? article.get() : null;
    }

    public ArticleDTO update(ArticleDTO articleDTO) {
        Article article = articleMapper.toEntity(articleDTO);
        return articleMapper.toDTO(articleRepository.save(article));
    }

    public ArticleDTO delete(final Long code) {
        ArticleDTO dto = articleMapper.toDTO(articleRepository.getReferenceById(code));
        articleRepository.deleteById(code);
        return dto;
    }

    @Autowired
    public void setArticleRepository(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Autowired
    public void setArticleMapper(ArticleMapper articleMapper) {
        this.articleMapper = articleMapper;
    }
}
