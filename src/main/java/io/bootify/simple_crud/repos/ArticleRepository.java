package io.bootify.simple_crud.repos;

import io.bootify.simple_crud.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
