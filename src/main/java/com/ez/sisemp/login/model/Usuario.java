package com.ez.sisemp.login.model;

import java.io.Serializable;

public record Usuario(Integer id, String nombreUsuario, String contrasena, String primerNombre, String apellidoPat, String fotoPerfilBase64, int rolId) implements Serializable {}