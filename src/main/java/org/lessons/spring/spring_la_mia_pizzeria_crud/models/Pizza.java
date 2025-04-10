package org.lessons.spring.spring_la_mia_pizzeria_crud.models;

import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.math.RoundingMode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity 
@Table(name = "pizzas") 
public class Pizza {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY )
    private Integer id;
    
    @NotBlank
    @Column(name = "pizza_name")
    @Size(min = 2, message = "the name must be of 3 or more characters")
    private String name;

    @Lob 
    private String description;

    @Column(name = "pizza_image")
    private String image;

    @NotNull
    @Min( value = 0, message = "price can not be null")
    private BigDecimal price;


    // Getter e Setter
    
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getImage(){
        return this.image;
    }

    public void setImage(String image){
        this.image = image;
    }

    public BigDecimal getPrice() {
        return price.setScale(2, RoundingMode.UP);
    }

    public void setPrice(BigDecimal price) {
        this.price = price.setScale(2, RoundingMode.UP);
    }



}
