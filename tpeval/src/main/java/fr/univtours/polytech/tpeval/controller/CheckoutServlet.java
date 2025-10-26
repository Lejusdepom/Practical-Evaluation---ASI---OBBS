package fr.univtours.polytech.tpeval.controller;

import fr.univtours.polytech.tpeval.model.Book;
import fr.univtours.polytech.tpeval.model.BorrowedList;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.*;

@WebServlet(name="checkoutServlet", urlPatterns ={"/checkout"})
public class CheckoutServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        List<Book> borrowedBooks = null;
        if (session != null) {
            BorrowedList borrowedList = (BorrowedList) session.getAttribute("borrowedList");
            if (borrowedList != null) {
                borrowedBooks = borrowedList.getBorrowedBooks();
            }
            session.invalidate();
        }

        double totalCost = 0.0;
        if (borrowedBooks != null && !borrowedBooks.isEmpty()) {
            for (Book book : borrowedBooks) {
                if ("physical".equalsIgnoreCase(book.getFormat())) {
                    totalCost += 10.0;
                }
                
                else if ("online".equalsIgnoreCase(book.getFormat())) {
                    totalCost += 5.0;
                }
            }
            request.setAttribute("borrowedBooks", borrowedBooks);
            request.setAttribute("totalCost", totalCost);
        }

        request.setAttribute("message", "Checkout OK");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/checkout.jsp");
        dispatcher.forward(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect("catalog");
            return;
        }

        BorrowedList borrowedList = (BorrowedList) session.getAttribute("borrowedList");

        if (borrowedList == null || borrowedList.getBorrowedBooks().isEmpty()) {
            request.setAttribute("message", "You haven't borrowed any books yet.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/checkout.jsp");
            dispatcher.forward(request, response);
            return;
        }

        List<Book> borrowedBooks = borrowedList.getBorrowedBooks();

        if (borrowedBooks.size() > 2) {
            request.setAttribute("error", "You can't borrow more than 2 books.");
        }

        double totalCost = 0.0;

        for (Book book : borrowedBooks) {
            if ("physical".equalsIgnoreCase(book.getFormat())) {
                totalCost += 10.0;
            }
            
            else if ("online".equalsIgnoreCase(book.getFormat())) {
                totalCost += 5.0;
            }
        }

        request.setAttribute("borrowedBooks", borrowedBooks);
        request.setAttribute("totalCost", totalCost);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/checkout.jsp");
        dispatcher.forward(request, response);
    }
}