package br.com.lincoln.model;

public class Space {
    private Integer valor;
    private final int esperado;
    private final boolean isFixo;

    public Space(int esperado, boolean isFixo) {
        this.esperado = esperado;
        this.isFixo = isFixo;
        if(isFixo)
            valor = esperado;
    }

    public Integer getValor() {
        return valor;
    }

    public void limparSpace(){
        setValor(null);
    }

    public void setValor(Integer valor) {
        if (this.isFixo) return;
        this.valor = valor;
    }

    public int getEsperado() {
        return esperado;
    }

    public boolean isFixo() {
        return isFixo;
    }
}
