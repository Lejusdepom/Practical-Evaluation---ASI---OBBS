package fr.univtours.polytech.tpeval.model;

import java.io.Serializable;
import java.util.ArrayList;

import jakarta.servlet.http.HttpSession;

public class BorrowedListBean implements Serializable{
    private Integer booksNumber; // Nombre de livre empruntés
    private ArrayList<Book> books; // Liste des livres empruntés
    private HttpSession userSession; // Session associé à la réservation

    public Integer getBooksNumber() {
        return booksNumber;
    }
    public void setBooksNumber(Integer booksNumber) {
        this.booksNumber = booksNumber;
    }
    public ArrayList<Book> getBooks() {
        return books;
    }
    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }
    public HttpSession getUserSession() {
        return userSession;
    }
    public void setUserSession(HttpSession userSession) {
        this.userSession = userSession;
    }

    public void addBook(Book book){
        this.books.add(book);
    }
    public void removeBook(Book book){
        this.books.remove(book);
    }
    
}
