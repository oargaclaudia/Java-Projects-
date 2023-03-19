package org.example.repo;

import org.example.domain.Bursa;
import org.example.domain.DatabaseException;

import java.sql.*;
import java.util.*;

public class ServiceManager implements Repository<Long, Bursa> {

    protected String url;
    protected String username;
    protected String password;
    public ServiceManager(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }


    @Override
    public Bursa getByID(Long aLong) {
        return null;
    }

    public Iterable<Bursa> getAll() throws DatabaseException {
        Set<Bursa> users = new HashSet<>();
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM burse");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                Long id = resultSet.getLong("id");
                String nume = resultSet.getString("nume");
                String prenume = resultSet.getString("prenume");
                String tip = resultSet.getString("tip");
                Double suma = resultSet.getDouble("suma");

                Bursa produs = new Bursa(id, nume, prenume, tip, suma);
                produs.setId(id);
                users.add(produs);
            }
            connection.close();
            return users;
        }
        catch(SQLException sqle) {
            String errorMessage = "\nEroare la citirea din BD:\n" + sqle.getMessage() + "\n> reincercati!";
            throw new DatabaseException(errorMessage);
        }
    }

    @Override
    public Bursa add(Bursa entity) {
        return null;
    }

    @Override
    public Bursa delete(Long aLong) {
        return null;
    }

    @Override
    public Bursa update(Bursa entity) {
        return null;
    }
}