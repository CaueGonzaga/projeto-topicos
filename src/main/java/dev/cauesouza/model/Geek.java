package dev.cauesouza.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;


@Entity
@Data
public class Geek {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    // @Column(nullable = false)
    private String description;

    // @Column(nullable = false)
    private String origin;

    private String rating;

    // @Column(nullable = false)
    private String model;

    // @Column(nullable = false)
    private double price;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;

}
