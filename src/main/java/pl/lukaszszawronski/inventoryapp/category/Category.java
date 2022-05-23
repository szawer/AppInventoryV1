package pl.lukaszszawronski.inventoryapp.category;

import lombok.Getter;
import lombok.Setter;
import pl.lukaszszawronski.inventoryapp.brand.Brand;

import javax.persistence.*;

@Entity
@Getter
@Setter

public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 45, nullable = false, unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    public Category() {
    }

    public Category(Integer id) {
        this.id = id;
    }

    public Category(String name) {
        this.name = name;
    }
}
