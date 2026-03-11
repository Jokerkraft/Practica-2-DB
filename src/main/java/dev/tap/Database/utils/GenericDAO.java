package dev.tap.Database.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class GenericDAO<T> {

    protected final Connection connection;

    protected GenericDAO(Connection connection) {
        this.connection = connection;
    }

    public abstract boolean save(T entity);

    public abstract boolean update(T entity);

    public abstract boolean delete(Long id);

    public abstract T findById(Long id);

    public abstract List<T> findAll();

    protected abstract T mapResultSetToEntity(ResultSet rs) throws SQLException;
}
