import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) {
        int numero;
        String agencia;
        String nomeCliente;
        double saldo;

        Scanner sc = new Scanner(System.in);

        System.out.println("Por favor, digite o número da Conta !");
        numero =  sc.nextInt();

        System.out.println("Por favor, digite o número da Agência !");
        agencia= sc.next();

        System.out.println("Por favor, digite o Nome do Cliente!");
        nomeCliente = sc.next();

        System.out.println("Por favor, digite o Saldo !");
        saldo = sc.nextDouble();

        System.out.println("Olá "+nomeCliente+", obrigado por criar uma conta em nosso banco, sua agência é "+agencia+", " +
                "conta "+numero+" e seu saldo "+saldo+" já está disponível para saque");

    }
}