package com.ez.sisemp.empleado.servlet;

import com.ez.sisemp.empleado.business.EmpleadoBusiness;
import com.ez.sisemp.empleado.exception.EmailAlreadyInUseException;
import com.ez.sisemp.empleado.model.Empleado;
import com.ez.sisemp.parametro.dao.ParametroDao;
import com.ez.sisemp.parametro.model.Departamento;
import com.ez.sisemp.shared.enums.Routes;
import com.ez.sisemp.shared.utils.SessionUtils;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet("/empleado/registrar")
public class RegistrarEmpleadoServlet extends HttpServlet {

    private EmpleadoBusiness empleadoBusiness;
    private ParametroDao parametroDao;

    @Override
    public void init() throws ServletException {
        super.init();
        empleadoBusiness = new EmpleadoBusiness();
        parametroDao = new ParametroDao();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (!SessionUtils.validarSesion(request, response)) {
            return;
        }
        loadDepartamentos(request);
        request.getRequestDispatcher("/empleado/registrar.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (!SessionUtils.validarSesion(request, response)) {
            return;
        }
        try {
            Empleado empleado = createEmpleadoFromRequest(request);
            empleadoBusiness.registrarEmpleado(empleado);
            request.setAttribute("msj", "Empleado registrado correctamente");
            response.sendRedirect(Routes.EMPLEADO.getRoute());
        } catch (ParseException e) {
            handleParseException(request, response, e);
        } catch (EmailAlreadyInUseException e){
            handleEmailAlreadyInUseException(request, response, e);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private Empleado createEmpleadoFromRequest(HttpServletRequest request) throws ParseException {
        String strDate = request.getParameter("fechaNacimiento");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        return new Empleado(
                request.getParameter("codigoEmpleado"),
                request.getParameter("nombres"),
                request.getParameter("apellidoPat"),
                request.getParameter("apellidoMat"),
                Integer.parseInt(request.getParameter("idDepartamento")),
                request.getParameter("correo"),
                Double.parseDouble(request.getParameter("salario")),
                sdf.parse(strDate));
    }

    private void handleParseException(HttpServletRequest request, HttpServletResponse response, ParseException e) throws ServletException, IOException {
        loadDepartamentos(request);
        request.setAttribute("error", "Fecha Nacimiento no válido, el formato debe ser yyyy-MM-dd");
        request.getRequestDispatcher("/empleado/registrar.jsp").forward(request, response);
    }

    private void handleEmailAlreadyInUseException(HttpServletRequest request, HttpServletResponse response, EmailAlreadyInUseException e) throws ServletException, IOException {
        loadDepartamentos(request);
        request.setAttribute("error", e.getMessage());
        request.getRequestDispatcher("/empleado/registrar.jsp").forward(request, response);
    }

    private void loadDepartamentos(HttpServletRequest request)  {
        List<Departamento> departamentos = parametroDao.obtenerDepartamentos();
        request.setAttribute("departamentos", departamentos);
    }
}