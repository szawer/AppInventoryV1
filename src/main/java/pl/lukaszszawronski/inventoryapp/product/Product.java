package pl.lukaszszawronski.inventoryapp.product;

import lombok.Getter;
import lombok.Setter;
import pl.lukaszszawronski.inventoryapp.category.Category;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    @Column(length = 128,nullable = false,unique = true)
    private String name;

    private float price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
