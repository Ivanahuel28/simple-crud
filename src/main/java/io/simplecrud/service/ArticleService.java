package io.simplecrud.service;

import io.bootify.simple_crud.domain.Article;
import io.simplecrud.dtos.ArticleDTO;
import io.simplecrud.mapper.ArticleMapper;
import io.simplecrud.repos.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@Service
public class ArticleService {

    private ArticleRepository articleRepository;
    private ArticleMapper articleMapper;

    public ArticleDTO create(final ArticleDTO articleDTO) {
        return articleMapper.toDTO(articleRepository.save(articleMapper.toEntity(articleDTO)));
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

    public void update(final ArticleDTO articleDTO) {
        final Article article = articleRepository.findById(articleDTO.getCode())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(articleDTO, article);
        articleRepository.save(article);
    }

    public void delete(final Long code) {
        articleRepository.deleteById(code);
    }

    public Article getArticleByCode(Long code) {
        Optional<Article> article = articleRepository.findById(code);
        return article.isPresent() ? article.get() : null;
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
