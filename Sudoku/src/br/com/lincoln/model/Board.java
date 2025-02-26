package br.com.lincoln.model;

import br.com.lincoln.enums.StatusEnum;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class Board {

    private final List<List<Space>> spaces;

    public Board(List<List<Space>> spaces) {
        this.spaces = spaces;
    }

    public List<List<Space>> getSpaces() {
        return spaces;
    }

    public StatusEnum getStatus(){
        if(spaces.stream().flatMap(Collection::stream).noneMatch(s-> !s.isFixo() && Objects.nonNull(s.getValor()))){
            return StatusEnum.NAO_INICIADO;
        }
        return spaces.stream().flatMap(Collection::stream).anyMatch(s-> Objects.isNull(s.getValor())) ? StatusEnum.INCOMPLETO : StatusEnum.COMPLETO;
    }

    public boolean hasErros(){
        if (getStatus() == StatusEnum.NAO_INICIADO)
            return false;

        return spaces.stream().flatMap(Collection::stream)
                .anyMatch(space -> Objects.nonNull(space.getValor()) && !space.getValor().equals(space.getEsperado()));
    }

    public boolean mudaValor(int col, int row, int valor){
        Space space = spaces.get(col).get(row);
        if(space.isFixo())
            return false;

        space.setValor(valor);
        return true;
    }

    public boolean limpaValor(int col, int row){
        Space space = spaces.get(col).get(row);
        if(space.isFixo())
            return false;

        space.setValor(null);
        return true;
    }

    public void reset(){
        spaces.forEach(s -> s.forEach(Space::limparSpace));
    }

    public boolean jogoFinalizado(){
        return !hasErros() && getStatus() == StatusEnum.COMPLETO;
    }

}
