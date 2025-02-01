import static org.junit.Assert.*;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class LibTeserJup {

	private static Library lib1;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		try {
			lib1 = new Library();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	@Order(1)
	public void testAddNewBook1() {
		System.out.println("testAddNewBook1");
		Book harry1 = new Book("Harry Potter 1");

		lib1.addNewBook(harry1);

		int numBooks = lib1.getNumOfAvalilabeBooks();
		assertEquals("#Books != 1!!!", 1, numBooks); // Verify that the number of available books = 1
		assertTrue("Book is not found!", lib1.isBookAvailable(harry1)); // Verify that the book is contained in the library object
	}

	@Test
	@Order(2)
	public void testLendBook2() {
		System.out.println("testLendBook2");
		Book harry2 = new Book("Harry Potter 2");
		lib1.addNewBook(harry2);

		Reader reader = new Reader("Yafit");
		lib1.lendBook(harry2, reader);

		int numBooks = lib1.getNumOfAvalilabeBooks();
		assertEquals("#Books != 1!!!", 1, numBooks); // Verify that the number of available books = 0
		assertFalse("Book is available!", lib1.isBookAvailable(harry2)); // Verify that the book is not available

		assertEquals("Wrong book lent!", harry2, lib1.getReaderLentBook(reader)); // verify that the book that is returned for this reader is harry
	}

	@Test
	@Order(3)
	public void testReturnBook3() {
		System.out.println("testReturnBook3");
		Book harry3 = new Book("Harry Potter 3");
		lib1.addNewBook(harry3);

		Reader reader = new Reader("Shlomit");
		lib1.lendBook(harry3, reader);

		lib1.returnBook(reader);

		int numBooks = lib1.getNumOfAvalilabeBooks();
		assertEquals("#Books != 2!!!", 2, numBooks); // Verify that the number of available books = 1
		assertTrue("Book is not found in available book list!", lib1.isBookAvailable(harry3)); // Verify that the book is found
		assertNull("reader still has a book!", lib1.getReaderLentBook(reader));
	}


	@Test
	@Order(4)
	public void testTwoReaders() {
		System.out.println("testTwoReaders");
		lib1.cleanLibrary();
		Book book1 = new Book("Book 1");
		Book book2 = new Book("Book 2");
		lib1.addNewBook(book1);
		lib1.addNewBook(book2);

		Reader reader1 = new Reader("Reader1");
		Reader reader2 = new Reader("Reader2");

		lib1.lendBook(book1, reader1);
		lib1.lendBook(book2, reader2);

		assertEquals("Number of readers should be 2", 2, lib1.getNumOfReaders());
	}

	@Test
	@Order(5)
	public void testFiveBooksAndTwoReaders() {
		System.out.println("testFiveBooksAndTwoReaders");
		lib1.cleanLibrary();

		// Create and add 5 books
		Book[] books = new Book[5];
		for (int i = 0; i < 5; i++) {
			books[i] = new Book("Book " + (i + 1));
			lib1.addNewBook(books[i]);
		}

		// Check initial book count
		assertEquals("Should have 5 books initially", 5, lib1.getNumOfAvalilabeBooks());

		// Create readers and lend books
		Reader reader1 = new Reader("Reader1");
		Reader reader2 = new Reader("Reader2");

		lib1.lendBook(books[0], reader1);
		lib1.lendBook(books[1], reader2);

		assertEquals("Should have 3 available books after lending", 3, lib1.getNumOfAvalilabeBooks());
		assertEquals("Should have 2 readers with books", 2, lib1.getNumOfReaders());
	}

	@Test
	@Order(6)
	public void testMultipleBooksPerReader() {
		System.out.println("testMultipleBooksPerReader");
		lib1.cleanLibrary();

		Book book1 = new Book("Book 1");
		Book book2 = new Book("Book 2");
		lib1.addNewBook(book1);
		lib1.addNewBook(book2);

		Reader reader = new Reader("Reader1");

		lib1.lendBook(book1, reader);
		lib1.lendBook(book2, reader);

		ArrayList<Book> readerBooks = lib1.getReaderLentBooks(reader);
		assertEquals("Reader should have 2 books", 2, readerBooks.size());
		assertTrue("Reader should have book1", readerBooks.contains(book1));
		assertTrue("Reader should have book2", readerBooks.contains(book2));
	}
}