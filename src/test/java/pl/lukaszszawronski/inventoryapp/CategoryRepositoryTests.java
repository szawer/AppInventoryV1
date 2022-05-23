package pl.lukaszszawronski.inventoryapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import pl.lukaszszawronski.inventoryapp.category.Category;
import pl.lukaszszawronski.inventoryapp.category.CategoryRepository;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class CategoryRepositoryTests {

    @Autowired
    private CategoryRepository repo;

    @Test
    public void testCreateCategory(){
        Category savedCategory = repo.save(new Category("Electronics"));
        assertThat(savedCategory.getId()).isGreaterThan(0);
    }
}
