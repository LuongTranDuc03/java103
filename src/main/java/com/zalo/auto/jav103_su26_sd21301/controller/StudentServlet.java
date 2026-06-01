package com.zalo.auto.jav103_su26_sd21301.controller;

import com.zalo.auto.jav103_su26_sd21301.entity.Student;
import com.zalo.auto.jav103_su26_sd21301.repository.StudentRepository;
import com.zalo.auto.jav103_su26_sd21301.service.StudentService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet", value = {
        "/students",
        "/students/new",
        "/students/insert",
        "/students/edit",
        "/students/delete",
        "/students/update"
})
public class StudentServlet extends HttpServlet {

    private StudentService service = new StudentService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path =  request.getServletPath();

        switch (path) {
            case "/students":
                listStudents(request, response);
                break;
            case "/students/new":
                showNewForm(request, response);
                break;
            case "/students/edit":
                showEditForm(request, response);
                break;
            case "/students/delete":
                deleteStudent(request, response);
                break;
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/views/addStudent.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Student student = service.getStudentById(id);
        request.setAttribute("student", student);
        request.getRequestDispatcher("/views/editStudent.jsp").forward(request, response);
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        service.deleteStudent(id);
        response.sendRedirect(request.getContextPath() + "/students");
    }

    private void listStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> students = service.getStudent();

        request.setAttribute("students", students);
        request.getRequestDispatcher("/views/studentList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path =  request.getServletPath();

        switch (path) {
            case "/students/insert":
                insertStudent(request, response);
                break;
            case "/students/update":
                updateStudent(request, response);
                break;
        }
    }

    private void insertStudent(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String idStr = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        String errorMessage = null;
        Long id = null;

        // Validation for ID
        if (idStr == null || idStr.trim().isEmpty()) {
            errorMessage = "Id is required!";
        } else {
            try {
                id = Long.parseLong(idStr.trim());
                // Check if ID already exists
                if (service.getStudentById(id) != null) {
                    errorMessage = "Id already exists!";
                }
            } catch (NumberFormatException e) {
                errorMessage = "Id must be a number!";
            }
        }

        // Validation for Name
        if (errorMessage == null && (name == null || name.trim().isEmpty())) {
            errorMessage = "Name is required!";
        }

        // If validation fails
        if (errorMessage != null) {
            Student student = new Student(id, name, email, phone);
            request.setAttribute("errorMessage", errorMessage);
            request.setAttribute("student", student);
            request.getRequestDispatcher("/views/addStudent.jsp").forward(request, response);
            return;
        }

        // Save to DB and redirect
        Student student = new Student(id, name, email, phone);
        service.addStudent(student);
        response.sendRedirect(request.getContextPath() + "/students");
    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String idStr = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        String errorMessage = null;
        Long id = null;

        try {
            id = Long.parseLong(idStr.trim());
        } catch (NumberFormatException e) {
            errorMessage = "Invalid Id!";
        }

        if (errorMessage == null && (name == null || name.trim().isEmpty())) {
            errorMessage = "Name is required!";
        }

        if (errorMessage != null) {
            Student student = new Student(id, name, email, phone);
            request.setAttribute("errorMessage", errorMessage);
            request.setAttribute("student", student);
            request.getRequestDispatcher("/views/editStudent.jsp").forward(request, response);
            return;
        }

        Student student = new Student(id, name, email, phone);
        service.updateStudent(student);
        response.sendRedirect(request.getContextPath() + "/students");
    }
}