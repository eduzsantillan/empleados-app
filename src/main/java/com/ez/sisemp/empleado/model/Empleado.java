package com.ez.sisemp.empleado.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public record Empleado(
        Integer id,
        String codigoEmpleado,
        String nombres,
        String apellidoPat,
        String apellidoMat,
        int idDepartamento,
        String departamento,
        String correo,
        int edad,
        double salario,
        Date fechaNacimiento
) implements Serializable {

    public Empleado(Integer id,String codigoEmpleado, String nombres, String apellidoPat, String apellidoMat, String departamento, String correo, int edad, double salario) {
        this(id, codigoEmpleado, nombres, apellidoPat, apellidoMat, 0, departamento, correo, edad, salario, null);
    }
    public Empleado(String codigoEmpleado, String nombres, String apellidoPat, String apellidoMat, String departamento, String correo, double salario, Date fechaNacimiento) {
        this(null, codigoEmpleado, nombres, apellidoPat, apellidoMat, 0, departamento, correo, 0, salario, fechaNacimiento);
    }

    public Empleado(String codigoEmpleado, String nombres, String apellidoPat, String apellidoMat, int idDepartamento, String correo, double salario, Date fechaNacimiento) {
        this(null, codigoEmpleado, nombres, apellidoPat, apellidoMat, idDepartamento, null, correo, 0, salario, fechaNacimiento);
    }

    public static List<String> getHeaders() {
        return List.of("Id", "Código", "Nombres", "Apellido Paterno", "Apellido Materno", "Departamento", "Correo", "Edad", "Salario");
    }
}