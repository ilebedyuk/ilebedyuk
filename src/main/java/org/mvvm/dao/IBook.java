package org.mvvm.dao;

import org.mvvm.Pojo.Book;

import java.util.List;

/**
 * @author amakarov
 */
public interface IBook {
    List<Book> findAllBooks();
    Book findBookById(int id);
}
