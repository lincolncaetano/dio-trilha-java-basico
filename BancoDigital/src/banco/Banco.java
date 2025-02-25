package banco;

import conta.Conta;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Banco {

    private String nome;
    private List<Conta> contas;

}
