package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    Product item1 = new Product(1, "хлеб", 40);
    Product item2 = new Product(2, "булка", 30);
    Product item3 = new Product(3, "картошка", 20);

    @Test
    public void testGenerationSuccess() {
        ShopRepository repo = new ShopRepository();
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(6);
        });
    }

    @Test
    public void testRemovalSuccess() {
        ShopRepository repo = new ShopRepository();
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);

        Product[] expected = {item1, item3};
        Product[] actual = repo.removeById(2);
        Assertions.assertArrayEquals(expected, actual);
    }
}