package br.com.lincolncaetano.dto;

import br.com.lincolncaetano.persistence.entity.BoardColumnKindEnum;

public record BoardColumnInfoDTO(Long id, int order, BoardColumnKindEnum kind) {
}
