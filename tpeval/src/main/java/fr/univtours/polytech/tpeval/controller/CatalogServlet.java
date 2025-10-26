package fr.univtours.polytech.tpeval.controller;

import fr.univtours.polytech.tpeval.model.Book;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.*;

@WebServlet(name="catalogServlet", urlPatterns ={"/catalog"})
public class CatalogServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Book> books = (List<Book>) getServletContext().getAttribute("books");

        if(books==null) {
            books = new ArrayList<>();
            books.add(new Book("1234567890", "Java Programming", "John Doe", 3, "A guide to Java", "physical"));
            books.add(new Book("0987654321", "Web Development", "Jane Smith", 2, "Learn web basics", "online"));
            books.add(new Book("1112131415", "Database Design", "Tom Brown", 1, "Relational DB concepts", "physical"));

            getServletContext().setAttribute("books", books);
        }

        request.setAttribute("books", books);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/catalog.jsp");
        dispatcher.forward(request, response);
    }
}