package dev.cauesouza.model;

import java.util.List;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class ShopCart {
    
     List <Geek> buycart;
}
