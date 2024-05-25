package com.ez.sisemp.admin.dao;

import com.ez.sisemp.admin.model.Usuario;
import com.ez.sisemp.shared.config.MySQLConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdminDao {

    private static final String GET_ALL_USERS = "SELECT * FROM usuario";

    public List<Usuario> obtenerUsuarios() throws SQLException, ClassNotFoundException {
        List<Usuario> usuarios = new ArrayList<>();
        Statement stp = MySQLConnection.getConnection().createStatement();
        ResultSet rs = stp.executeQuery(GET_ALL_USERS);
        while(rs.next()){
            usuarios.add(mapRow(rs));
        }
        return usuarios;
    }


    public Usuario mapRow(ResultSet rs) throws SQLException {

        String rolDescripcion;
        if(rs.getInt("id_rol") == 1){
            rolDescripcion = "Administrador";
        }else{
            rolDescripcion = "Usuario";
        }

        return new Usuario(
            rs.getInt("id"),
            rs.getString("nombre_usuario"),
            rs.getString("contrasena"),
            rs.getString("contrasena_anterior"),
            rs.getDate("ultima_conexion"),
            rs.getBoolean("active"),
            rs.getString("primer_nombre"),
            rs.getString("apellido_pat"),
            rs.getString("foto_perfil"),
            rolDescripcion
        );
    }



}
