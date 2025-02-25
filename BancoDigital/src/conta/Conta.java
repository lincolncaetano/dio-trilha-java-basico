package conta;

public class Conta implements IConta{


    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        this.saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        sacar(valor);
        contaDestino.depositar(valor);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println(String.format("Cliente: "+ this.cliente.getNome()));
        System.out.println(String.format("Agencia: "+ this.agencia));
        System.out.println(String.format("Numero: "+ this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }

    public String nomeCliente(){
        return  cliente.getNome();
    }
}
