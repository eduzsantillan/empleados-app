package com.ez.sisemp.shared.enums;

public enum Routes {
    EMPLEADO("/empleado"),
    ADMIN("/admin"),
    USUARIO("/usuario"),
    LOGIN("/login"),
    NOTFOUND("/notfound"),
    LOGOUT("/logout");

    private final String route;

    Routes(String route) {
        this.route = route;
    }

    public String getRoute() {
        return route;
    }
}
