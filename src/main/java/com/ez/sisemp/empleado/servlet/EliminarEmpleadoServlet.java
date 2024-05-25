package com.ez.sisemp.empleado.servlet;

import com.ez.sisemp.empleado.business.EmpleadoBusiness;
import com.ez.sisemp.shared.enums.Routes;
import com.ez.sisemp.shared.utils.SessionUtils;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/empleado/eliminar")
public class EliminarEmpleadoServlet extends HttpServlet {

    @Override
    public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (!SessionUtils.validarSesion(request, response)) {
            return;
        }
        EmpleadoBusiness business = new EmpleadoBusiness();
        try {
            business.eliminarEmpleado(Integer.parseInt(request.getParameter("id")));
            request.setAttribute("msj", "Empleado eliminado correctamente");
            response.sendRedirect(Routes.EMPLEADO.getRoute());
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
