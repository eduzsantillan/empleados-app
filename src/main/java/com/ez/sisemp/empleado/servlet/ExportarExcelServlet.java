package com.ez.sisemp.empleado.servlet;

import com.ez.sisemp.empleado.business.EmpleadoBusiness;
import com.ez.sisemp.empleado.model.Empleado;
import com.ez.sisemp.shared.utils.ExcelExporter;
import com.ez.sisemp.shared.utils.SessionUtils;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/empleado/exportar-excel")
public class ExportarExcelServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        if (!SessionUtils.validarSesion(req, res)) {
            return;
        }
        EmpleadoBusiness business = new EmpleadoBusiness();
        try {
            List<Empleado> empleados = business.obtenerEmpleados();
            ExcelExporter.createExcelFile(Empleado.getHeaders(), empleados, "empleados", res);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
