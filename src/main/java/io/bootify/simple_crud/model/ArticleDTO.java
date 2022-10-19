package io.bootify.simple_crud.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ArticleDTO {

    private Long code;

    @NotNull
    @Size(max = 255)
    private String description;

    private Double price;

}
