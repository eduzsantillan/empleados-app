package com.ez.sisemp.login.dao;

import com.ez.sisemp.shared.config.MySQLConnection;
import com.ez.sisemp.login.exception.UserOrPassIncorrectException;
import com.ez.sisemp.login.model.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDao {
    private static final String SQL_GET_USER = "SELECT * FROM usuario WHERE nombre_usuario = ? AND contrasena = ?";
    public Usuario login(String username, String password) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = MySQLConnection.getConnection()
                                                .prepareStatement(SQL_GET_USER);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            return mapResultSetToUsuario(resultSet);
        }else {
            throw new UserOrPassIncorrectException("Usuario o contraseña incorrectos");
        }
    }

    private Usuario mapResultSetToUsuario(ResultSet resultSet) throws SQLException {
        return new Usuario(resultSet.getInt("id"),
                resultSet.getString("nombre_usuario"),
                resultSet.getString("contrasena"),
                resultSet.getString("primer_nombre"),
                resultSet.getString("apellido_pat"),
                resultSet.getString("foto_perfil"),
                resultSet.getInt("id_rol")
        );
    }
}
