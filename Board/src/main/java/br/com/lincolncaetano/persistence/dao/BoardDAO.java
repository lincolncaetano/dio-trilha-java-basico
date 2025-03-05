package br.com.lincolncaetano.persistence.dao;

import br.com.lincolncaetano.persistence.entity.BoardEntity;
import com.mysql.cj.jdbc.StatementImpl;
import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

@AllArgsConstructor
public class BoardDAO {

    private Connection connection;

    public BoardEntity insert(final BoardEntity board) throws SQLException {
        var sql = "INSERT INTO BOARDS (name) values (?);";
        try(var stant = connection.prepareStatement(sql)){
            stant.setString(1,board.getName());
            stant.executeUpdate();
            if (stant instanceof StatementImpl impl){
                board.setId(impl.getLastInsertID());
            }
            return  board;
        }
    }

    public void delete(final Long id) throws SQLException {
        var sql = "DELETE FROM BOARDS WHERE id = ?;";
        try(var stant = connection.prepareStatement(sql)){
            stant.setLong(1, id);
            stant.executeUpdate();
        }
    }

    public Optional<BoardEntity> findById(final Long id) throws SQLException {
        var sql = "SELECT id, name FROM BOARDS WHERE id = ?;";
        try(var statement = connection.prepareStatement(sql)){
            statement.setLong(1, id);
            statement.executeQuery();
            var resultSet = statement.getResultSet();
            if (resultSet.next()){
                var entity = new BoardEntity();
                entity.setId(resultSet.getLong("id"));
                entity.setName(resultSet.getString("name"));
                return Optional.of(entity);
            }
            return Optional.empty();
        }
    }


    public boolean exists(final Long id) throws SQLException {
        var sql = "SELECT 1 FROM BOARDS WHERE id = ?;";
        try(var statement = connection.prepareStatement(sql)){
            statement.setLong(1, id);
            statement.executeQuery();
            return statement.getResultSet().next();
        }
    }

}
