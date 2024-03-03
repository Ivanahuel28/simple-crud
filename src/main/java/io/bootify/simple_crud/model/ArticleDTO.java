package io.bootify.simple_crud.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ArticleDTO {

    private Long code;

    @NotNull
    @Size(max = 255)
    private String description;

    private Double price;

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
