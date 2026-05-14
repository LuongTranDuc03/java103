package com.zalo.auto.jav103_su26_sd21301;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "StudentServlet", value = "/StudentServlet")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String country = request.getParameter("country");
        String[] favoriteLanguages = request.getParameterValues("favoriteLanguage");

        out.println("<html><body>");
        out.println("<h1>Student Data Submitted</h1>");
        out.println("<p>First Name: " + firstName + "</p>");
        out.println("<p>Last Name: " + lastName + "</p>");
        out.println("<p>Country: " + country + "</p>");

        out.println("<p>Favorite Languages: ");
        if (favoriteLanguages != null) {
            for (String lang : favoriteLanguages) {
                out.println(lang + " ");
            }
        } else {
            out.println("None selected");
        }
        out.println("</p>");

        out.println("<br><a href='index.jsp'>Back to Form</a>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}