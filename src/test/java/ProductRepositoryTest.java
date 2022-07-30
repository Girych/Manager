import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {

    Book book1 = new Book(30, "Transformers", 1000, "Ilya");
    Book book2 = new Book(40, "Harry Botter", 1500, "Ivan");
    Book book3 = new Book(50, "Harry Fire", 2000, "Petya");
    Smartphone smartphone1 = new Smartphone(31, "Nokia", 10000, "China");
    Smartphone smartphone2 = new Smartphone(41, "Samsung", 20000, "India");

    Product[] products = {book1,book2,book3,smartphone1,smartphone2};
    Repository repo = new Repository();

    @Test
    public void shouldAdd() {
        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.add(smartphone1);
        repo.add(smartphone2);

        Product[] actual = repo.findAll();
        Product[] expected = {book1,book2,book3,smartphone1,smartphone2};

        assertArrayEquals(expected,actual);
    }

    @Test
    public void shouldRemove() {
        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.add(smartphone1);
        repo.add(smartphone2);
        repo.removeById(41);
        Product[] actual = repo.findAll();
        Product[] expected = {book1,book2,book3,smartphone1};

        assertArrayEquals(expected,actual);
    }
}