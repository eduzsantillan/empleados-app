package com.ez.sisemp.empleado.business;

import com.ez.sisemp.empleado.dao.EmpleadoDao;
import com.ez.sisemp.empleado.dao.EmpleadoDashboardDao;
import com.ez.sisemp.empleado.exception.EmailAlreadyInUseException;
import com.ez.sisemp.empleado.exception.EmpleadosNotFoundException;
import com.ez.sisemp.empleado.model.Empleado;
import com.ez.sisemp.empleado.model.EmpleadoDashboard;
import org.apache.commons.lang3.StringUtils;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

public class EmpleadoBusiness {

    private final EmpleadoDao empleadoDao;
    private final EmpleadoDashboardDao empleadoDashboardDao;

    public EmpleadoBusiness(){
        this.empleadoDao = new EmpleadoDao();
        this.empleadoDashboardDao = new EmpleadoDashboardDao();
    }

    public void registrarEmpleado(Empleado empleado) throws SQLException, ClassNotFoundException {
        empleado = new Empleado(generarCodigoEmpleado(), empleado.nombres(), empleado.apellidoPat(), empleado.apellidoMat(), empleado.idDepartamento(), empleado.correo(), empleado.salario(), empleado.fechaNacimiento());
        validarCampos(empleado);
        try {
            empleadoDao.agregarEmpleado(empleado);
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new EmailAlreadyInUseException(String.format("El correo %s ya se encuentra registrado", empleado.correo()));
        }
    }

    public void eliminarEmpleado(int id) throws SQLException, ClassNotFoundException {
        empleadoDao.eliminarEmpleado(id);
    }

    public List<Empleado> obtenerEmpleados() throws SQLException, ClassNotFoundException {
        var empleados = empleadoDao.obtenerEmpleados();
        if(empleados.isEmpty()){
            throw new EmpleadosNotFoundException("No se encontraron empleados");
        }
        return empleadoDao.obtenerEmpleados();
    }

    public EmpleadoDashboard obtenerDatosDashboard() throws SQLException, ClassNotFoundException {
        return empleadoDashboardDao.get();
    }

    private String generarCodigoEmpleado(){
        return "EMP" + (int) (Math.random() * 1000000);
    }

    private void validarCampos (Empleado empleado){
        if(StringUtils.isBlank(empleado.codigoEmpleado())){
            throw new IllegalArgumentException("El codigo del empleado no puede ser nulo");
        }
        if(StringUtils.isBlank(empleado.nombres())){
            throw new IllegalArgumentException("El nombre del empleado no puede ser nulo");
        }
        if(StringUtils.isBlank(empleado.apellidoPat())){
            throw new IllegalArgumentException("El apellido paterno del empleado no puede ser nulo");
        }
        if(StringUtils.isBlank(empleado.correo())){
            throw new IllegalArgumentException("El correo del empleado no puede ser nulo");
        }
        if(StringUtils.isBlank(empleado.fechaNacimiento().toString())){
            throw new IllegalArgumentException("La fecha de nacimiento del empleado no puede ser nula");
        }
        if(empleado.salario() < 0){
            throw new IllegalArgumentException("El salario del empleado no puede ser negativo");
        }
    }
}
