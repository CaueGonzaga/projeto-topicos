package dev.cauesouza.dto;

import dev.cauesouza.model.Geek;
import lombok.Getter;

@Getter
public class GeekResponseDTO {
    
    private String description;
    private String origin;
    private String rating;
    private String categories;
    private Double price;
    
    public GeekResponseDTO(Geek geek){
        this.description = geek.getDescription();
        this.origin = geek.getOrigin();
        this.rating = geek.getRating();
        this.categories = geek.getCategory().getName();
        this.price = geek.getPrice();
    }
    // public GeekResponseDTO(Long id, String description, String categories){
    //     this.id = id;
    //     this.description = description;
    //     this.categories = categories;
    // }
    
}
