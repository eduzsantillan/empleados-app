package com.ez.sisemp.parametro.dao;

import com.ez.sisemp.parametro.entity.DepartamentoEntity;
import com.ez.sisemp.parametro.exception.GetParametroException;
import com.ez.sisemp.parametro.model.Departamento;
import com.ez.sisemp.shared.config.MySQLConnection;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ParametroDao {

    private static final String SQL_SELECT_DEPARTAMENTOS = "SELECT id,codigo,nombre FROM departamentos";
    private final Logger logger = Logger.getLogger(ParametroDao.class.getName());
    private final EntityManager entityManager;

    public ParametroDao() {
        var EntityManagerFactory = Persistence.createEntityManagerFactory("devUnit");
        this.entityManager = EntityManagerFactory.createEntityManager();
    }

    public List<Departamento> obtenerDepartamentos()  {
        logger.info("Obteniendo departamentos");
        List<Departamento> departamentos = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = MySQLConnection.getConnection()
                    .prepareStatement(SQL_SELECT_DEPARTAMENTOS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                departamentos.add(new Departamento(resultSet.getInt("id"),
                        resultSet.getString("codigo"),
                        resultSet.getString("nombre")
                ));
            }
        } catch (SQLException | ClassNotFoundException e) {
            logger.info(String.format("Error al obtener los departamentos: %s", e.getMessage()));
            throw new GetParametroException("Error al obtener los departamentos");
        }
        logger.info(String.format("Se obtuvieron %d departamentos", departamentos.size()) );
        return departamentos;
    }

    public DepartamentoEntity getById (Integer departamentoId) {
        return entityManager.find(DepartamentoEntity.class, departamentoId);
    }

}
