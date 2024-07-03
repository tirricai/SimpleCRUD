package com.juampicrud.my_crud.repositories;

import com.juampicrud.my_crud.model.Book;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//Se encarga de la conexion con la base de datos (jdbc)
@Repository
public class BookRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    private final BookMapper bookMapper = new BookMapper();

    private final SimpleJdbcInsert insert;

    private final String table = "books";

    public BookRepository(NamedParameterJdbcTemplate jdbcTemplate, DataSource dataSource) {
        this.jdbcTemplate = jdbcTemplate;
        this.insert = new SimpleJdbcInsert(dataSource).withTableName(table)
                .usingGeneratedKeyColumns("id");
    }

    public List<Book> findAll() {
        String sql = "select * from table";
        return jdbcTemplate.query(sql, bookMapper);
    }

    public long createBook(Book newBook) {
        return insert.executeAndReturnKey(
                new MapSqlParameterSource("name", newBook.name)
        ).longValue();
    }

    public static class BookMapper implements RowMapper<Book> {

        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
           long id = rs.getLong("id");
           String name = rs.getString("name");

            return new Book(id, name);
        }
    }
}