package com.ez.sisemp.admin.servlet;

import com.ez.sisemp.admin.dao.AdminDao;
import com.ez.sisemp.shared.utils.SessionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

    private static final String ADMIN_JSP = "/admin/admin.jsp";

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if(!SessionUtils.validarSesion(request, response)){
            return;
        }
        AdminDao dao = new AdminDao();
        try {
            request.setAttribute("usuarios", dao.obtenerUsuarios());
            request.getRequestDispatcher(ADMIN_JSP).forward(request, response);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

}
