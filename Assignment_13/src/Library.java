
import java.util.ArrayList;
import java.util.HashMap;

public class Library {
    private ArrayList<Book> availableBooks;
    private HashMap<Reader, ArrayList<Book>> lentBooks;  // Changed to support multiple books per reader
    
    public int getNumOfReaders() {
        return lentBooks.size();
    }
    
    public void cleanLibrary() {
        availableBooks.clear();
        lentBooks.clear();
    }
    
    public void addNewBook(Book book) {
        availableBooks.add(book);
    }   
    
    public boolean lendBook(Book book, Reader reader) {
        if (!availableBooks.contains(book))
            return false;
            
        if (!lentBooks.containsKey(reader)) {
            lentBooks.put(reader, new ArrayList<Book>());
        }
        
        availableBooks.remove(book);
        lentBooks.get(reader).add(book);
        return true;
    }
    
    public boolean returnBook(Reader reader) {
        if (!lentBooks.containsKey(reader))           
            return false;
        
        ArrayList<Book> books = lentBooks.get(reader);
        availableBooks.addAll(books);
        lentBooks.remove(reader);
        return true;           
    }
    
    public int getNumOfAvalilabeBooks() {
        return availableBooks.size();
    }
    
    public boolean isBookAvailable(Book book) {
        return availableBooks.contains(book);
    }
    
    public Book getReaderLentBook(Reader reader) {
        ArrayList<Book> books = lentBooks.get(reader);
        return books != null && !books.isEmpty() ? books.get(0) : null;
    }

    public ArrayList<Book> getReaderLentBooks(Reader reader) {
        return lentBooks.get(reader);
    }

        
    public Library() {
        availableBooks = new ArrayList<Book>();
        lentBooks = new HashMap<Reader, ArrayList<Book>>();
    }

}