package homework31;

import org.junit.jupiter.api.*;
import homework31.dao.Library;
import homework31.entity.Book;
import homework31.utils.HibernateUtil;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LibraryTest {

    private static Library library;
    private static Book testBook;

    @BeforeAll
    static void setup() {
        System.out.println("Before all tests message");
        library = new Library();
    }

    @AfterAll
    static void cleanUp() {
        System.out.println("After all tests message");
        HibernateUtil.shutDown();
    }

    @BeforeEach
    void prepareTestBook() {
        System.out.println("Before each: Preparing book for test");
        testBook = new Book();
        testBook.setTitle("Test Book");
        testBook.setAuthor("Test Author");

        System.out.println("Book is valid: " + testBook.isValid());
        System.out.println("Title: " + testBook.getTitle());
        System.out.println("Author: " + testBook.getAuthor());

        library.addBook(testBook);
    }

    @AfterEach
    void cleanTestBook() {
        System.out.println("After each: Deleting test book from db");
        library.removeBook(testBook.getId());
    }

    @Test
    @Order(1)
    void testAddBookAndGetCountBooks() {
        Book book = new Book("Kobzar", "Shevchenko");
        library.addBook(book);
        int bookCount = library.getBookCount();
        assertTrue(bookCount > 1);
    }

    @Test
    @Order(2)
    void testExceptionsWhileAddingBook() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                library.addBook(new Book(null, "some info")));
        assertEquals("Wrong data", exception.getMessage());
        IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class, () ->
                library.addBook(null));
        assertEquals("Wrong data", exception2.getMessage());
        IllegalArgumentException exception3 = assertThrows(IllegalArgumentException.class, () ->
                library.addBook(new Book("Valid title", null)));
        assertEquals("Wrong data", exception3.getMessage());
    }

    @Test
    @Order(3)
    void testRemoveBook() {
        boolean isDeleted = library.removeBook(testBook.getId());
        assertTrue(isDeleted);
    }

    @Test
    @Order(4)
    void testExceptionsWhileRemovingBook() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            library.removeBook(0);
        });
        assertEquals("Wrong id", exception.getMessage());
        IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class, () -> {
            library.removeBook(9999);
        });
        assertEquals("Wrong data provided", exception2.getMessage());
    }

    @Test
    @Order(5)
    void testGetBooks() {
        List<Book> books = library.getBooks();
        books.forEach(Assertions::assertNotNull);
        books.forEach(book -> assertNotNull(book.getId()));
    }
}
