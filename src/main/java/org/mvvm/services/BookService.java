package org.mvvm.services;

import org.mvvm.Pojo.Book;
import org.mvvm.dao.IBook;

import java.util.List;

/**
 * @author amakarov
 */
public class BookService {
    private IBook iBook;

    public BookService(IBook iBook) {
        this.iBook = iBook;
    }

    public List<Book> findAllBooks(){
        return iBook.findAllBooks();
    }

    public Book findBookById(int id){
        return iBook.findBookById(id);
    }
}
