package io.bootify.simple_crud;

import io.bootify.simple_crud.domain.Article;
import io.bootify.simple_crud.repos.ArticleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class SimpleCrudApplication {

    public static void main(final String[] args) {
        SpringApplication.run(SimpleCrudApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(ArticleRepository repository) {
        return (args) -> {
            repository.save(new Article(1L,"Botella de Agua",122D));
        };
    }

}
