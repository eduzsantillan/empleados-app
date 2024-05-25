package com.ez.sisemp.empleado.servlet;

import com.ez.sisemp.empleado.model.Empleado;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/empleado/editar")
public class EditarEmpleadoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        req.getRequestDispatcher("/empleado/editar.jsp").forward(req, resp);
    }
}
