package com.ez.sisemp.empleado.model;

public record EmpleadoDashboard(
    int totalEmpleados,
    double mayorSalario,
    int promedioEdad,
    int totalDepartamentos
) {
}
