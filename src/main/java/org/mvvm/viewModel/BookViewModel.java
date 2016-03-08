package org.mvvm.viewModel;

import org.mvvm.Pojo.Book;
import org.mvvm.dao.lists.BookDaoImpl;
import org.mvvm.services.BookService;
import org.zkoss.bind.annotation.Init;

import java.util.List;

/**
 * @author amakarov
 */
public class BookViewModel {
    private List<Book> books;
    private Book selectedBook;

    private BookService bookService = new BookService(new BookDaoImpl());

    public BookViewModel(BookService bookService) {
        this.bookService = bookService;
    }

    public BookViewModel() {}

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Book getSelectedBook() {
        return selectedBook;
    }

    public void setSelectedBook(Book selectedBook) {
        this.selectedBook = selectedBook;
    }

    @Init
    public void loadBooks() {
        books = bookService.findAllBooks();
    }

//    @Command
//    @NotifyChange("books")
//    public void showBooks() {
//        books = bookService.findAllBooks();
//    }
}
