package com.ez.sisemp.login.enumeration;

public enum Roles {
    ADMIN(1),
    USER(2),
    GUEST(3);
    private final int id;

    Roles(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
}
