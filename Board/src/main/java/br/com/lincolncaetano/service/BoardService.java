package br.com.lincolncaetano.service;

import br.com.lincolncaetano.persistence.dao.BoardColumnDAO;
import br.com.lincolncaetano.persistence.dao.BoardDAO;
import br.com.lincolncaetano.persistence.entity.BoardEntity;
import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.SQLException;

@AllArgsConstructor
public class BoardService {

    private Connection connection;

    public boolean delete(Long id) throws SQLException {
        BoardDAO boardDAO = new BoardDAO(connection);
        try {
            if(boardDAO.exists(id)){
                boardDAO.delete(id);
                return true;
            }
            else {
                return false;
            }
        }catch (SQLException e){
            connection.rollback();
            throw e;
        }

    }


    public BoardEntity insert(final BoardEntity entity) throws SQLException {
        var dao = new BoardDAO(connection);
        var boardColumnDAO = new BoardColumnDAO(connection);
        try{
            dao.insert(entity);
            var columns = entity.getBoardColumns().stream().map(c -> {
                c.setBoard(entity);
                return c;
            }).toList();
            for (var column :  columns){
                boardColumnDAO.insert(column);
            }
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        }
        return entity;
    }
}
