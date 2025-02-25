import banco.Banco;
import conta.Cliente;
import conta.Conta;
import conta.ContaCorrente;
import conta.ContaPoupanca;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Cliente cliente1 = new Cliente();
        cliente1.setNome("Cliente 1");

        Cliente cliente2 = new Cliente();
        cliente2.setNome("Cliente 2");

        Conta cc = new ContaCorrente(cliente1);
        Conta poupanca = new ContaPoupanca(cliente2);

        cc.depositar(100);
        cc.transferir(100, poupanca);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();


        Banco banco = new Banco();
        banco.setNome("BB");

        List<Conta> contasBanco = new ArrayList<>();
        contasBanco.add(cc);
        contasBanco.add(poupanca);

        banco.setContas(contasBanco);


        banco.getContas().forEach(c -> System.out.println(c.nomeCliente()));


    }
}