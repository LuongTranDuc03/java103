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
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Lấy dữ liệu nhập từ index.jsp
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String country = request.getParameter("country");
        String[] favoriteLanguages = request.getParameterValues("favoriteLanguage");

        // Chuyển dữ liệu sang views (student.jsp)
        request.setAttribute("firstName", firstName);
        request.setAttribute("lastName", lastName);
        request.setAttribute("country", country);
        request.setAttribute("favoriteLanguages", favoriteLanguages);

        // Chỉ định file nhận dữ liệu
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/student.jsp");

        // Đưa dữ liệu sang .jsp
        requestDispatcher.forward(request, response);
    }
}