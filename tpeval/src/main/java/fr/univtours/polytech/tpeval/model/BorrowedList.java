package fr.univtours.polytech.tpeval.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BorrowedList implements Serializable {

    private List<Book> borrowedBooks = new ArrayList<>();

    public void addBook(Book book) {
        borrowedBooks.add(book);
    }

    public void removeBook(String isbn) {
        for (int i = 0; i < borrowedBooks.size(); i++) {
            if (borrowedBooks.get(i).getIsbn().equals(isbn)) {
                borrowedBooks.remove(i);
                break;
            }
        }
    }

    public List<Book> getBorrowedBooks() { return borrowedBooks;}
}