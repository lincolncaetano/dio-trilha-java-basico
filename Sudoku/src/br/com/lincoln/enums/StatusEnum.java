package br.com.lincoln.enums;

public enum StatusEnum {
    NAO_INICIADO("não iniciado"),
    INCOMPLETO("incompleto"),
    COMPLETO("completo");

    private String label;

    StatusEnum(final String label){
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
