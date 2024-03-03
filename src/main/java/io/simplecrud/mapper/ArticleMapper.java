package io.simplecrud.mapper;

import io.bootify.simple_crud.domain.Article;
import io.simplecrud.dtos.ArticleDTO;

public class ArticleMapper {

    public ArticleDTO toDTO( Article article ) {
        ArticleDTO dto = new ArticleDTO();
        dto.setCode(article.getCode());
        dto.setDescription(article.getDescription());
        dto.setPrice(article.getPrice());
        return dto;
    }

    public Article toEntity( ArticleDTO articleDTO ) {
        Article entity = new Article();
        entity.setDescription(articleDTO.getDescription());
        entity.setPrice(articleDTO.getPrice());
        return entity;
    }
}
