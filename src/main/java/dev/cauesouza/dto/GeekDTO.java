package dev.cauesouza.dto;

import lombok.Getter;

@Getter
public class GeekDTO {

    private String description;
    private String origin;
    private String rating;
    private String model;
    private double price;
    private Long idCategory;

    public GeekDTO (String description, String origin, String rating, String model, double price, Long idCategory){
        this.description = description;
        this.origin = origin;
        this.rating = rating;
        this.model = model;
        this.price = price;
        this.idCategory = idCategory;
    }

}
