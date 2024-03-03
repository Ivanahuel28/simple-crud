package io.bootify.simple_crud.domain;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;


@Entity
@Table
@EntityListeners(AuditingEntityListener.class)
public class Article {

    @Id
    @Column
    private Long code;

    @Column
    private String description;

    @Column
    private Double price;

    public Article() {
        // Empty method
    }

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
