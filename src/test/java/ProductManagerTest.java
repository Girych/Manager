import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    Repository repo = new Repository();
    ProductManager manager = new ProductManager(repo);

    Book book1 = new Book(30, "Transformers", 1000, "Ilya");
    Book book2 = new Book(40, "Harry Botter", 1500, "Ivan");
    Book book3 = new Book(50, "Harry Fire", 2000, "Petya");
    Smartphone smartphone1 = new Smartphone(31, "Nokia", 10000, "China");
    Smartphone smartphone2 = new Smartphone(41, "Samsung", 20000, "India");

    @Test
    public void test() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] actual = manager.searchBy("Harry");
        Product[] expected = {book2, book3};

        assertArrayEquals(expected, actual);
    }
    @Test
    public void test2() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] actual = manager.searchBy("Nokia");
        Product[] expected = {smartphone1};

        assertArrayEquals(expected, actual);
    }
    @Test
    public void test3() {
        manager.add(book3);
        manager.add(smartphone1);

        Product[] actual = repo.findAll();
        Product[] expected = {book3,smartphone1};

        assertArrayEquals(expected, actual);

    }

}
