package fr.univtours.polytech.tpeval.controller;

import fr.univtours.polytech.tpeval.model.Book;
import fr.univtours.polytech.tpeval.model.BorrowedList;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.*;

@WebServlet(name="borrowedBooks", urlPatterns={"/reserve", "/return", "/borrowed"})
public class BorrowServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        HttpSession session = request.getSession();

        List<Book> books = (List<Book>) getServletContext().getAttribute("books");

        if (books == null) {
            response.sendRedirect("catalog");
            return;
        }

        BorrowedList borrowedList = (BorrowedList) session.getAttribute("borrowedList");
        if (borrowedList == null) {
            borrowedList = new BorrowedList();
            session.setAttribute("borrowedList", borrowedList);
        }

        String isbn = request.getParameter("isbn");

        switch (path) {
            case "/reserve":
                for (Book b : books) {
                    if (b.getIsbn().equals(isbn) && b.getAvailableCopies() > 0) {
                        b.setAvailableCopies(b.getAvailableCopies() - 1);
                        borrowedList.addBook(b);
                        break;
                    }
                }
                response.sendRedirect("borrowed");
                return;

            case "/return":
                borrowedList.removeBook(isbn);
                for (Book b : books) {
                    if (b.getIsbn().equals(isbn)) {
                        b.setAvailableCopies(b.getAvailableCopies() + 1);
                        break;
                    }
                }
                session.setAttribute("borrowedList", borrowedList);
                response.sendRedirect("borrowed");
                return;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        BorrowedList borrowedList = (BorrowedList) session.getAttribute("borrowedList");

        if (borrowedList == null) {
            borrowedList = new BorrowedList();
            session.setAttribute("borrowedList", borrowedList);
        }

        request.setAttribute("borrowedBooks", borrowedList.getBorrowedBooks());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/borrowed.jsp");
        dispatcher.forward(request, response);
    }
}