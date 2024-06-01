package com.ez.sisemp.shared.utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class EdadUtils {
    public static int calcularEdad(Date fechaNacimiento) {
        LocalDate localBirthDate = fechaNacimiento.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(localBirthDate, currentDate);
        return period.getYears();
    }
}
