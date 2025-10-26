package fr.univtours.polytech.tpeval.controller;

import java.io.IOException;

import fr.univtours.polytech.tpeval.model.business.BorrowBusiness;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="borrowServlet", urlPatterns = "/borrowed")
public class BorrowServlet extends HttpServlet {

    private BorrowBusiness borrowBusiness;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }
}
