package org.mvvm.dao.lists;

import org.mvvm.Pojo.Book;
import org.mvvm.dao.IBook;

import java.util.LinkedList;
import java.util.List;

/**
 * @author amakarov
 */
public class BookDaoImpl implements IBook {
    private List<Book> bookList = new LinkedList<Book>();
    private static int id = 1;

    public BookDaoImpl(){
        bookList.add(new Book(id++, "1984"));
        bookList.add(new Book(id++, "Harry Potter"));
        bookList.add(new Book(id++, "Game oj the Throne"));
    }

    @Override
    public List<Book> findAllBooks() {
        return bookList;
    }

    @Override
    public Book findBookById(int id) {
        return bookList.get(id);
    }
}
