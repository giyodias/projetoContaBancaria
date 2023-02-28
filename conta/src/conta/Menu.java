package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.util.Cores;
import conta.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;

public class Menu {

	public static void main(String[] args) {
		ContaController contas = new ContaController();
		Scanner leia = new Scanner(System.in);
		int opcao, numero, agencia, tipo, aniversario, numeroDestino;
		String titular;
		float saldo, limite, valor;
		
		while(true) {
	
		System.out.println(Cores.TEXT_GREEN_BRIGHT + Cores.ANSI_BLACK_BACKGROUND
						   + "-----------------------------------------------------");
		System.out.println("                                                     ");
		System.out.println("               -BANCO DO BRAZIL COM Z-               ");
		System.out.println("                                                     ");
		System.out.println("-----------------------------------------------------");
		System.out.println("                                                     ");
		System.out.println("             1 - Criar conta                         ");
		System.out.println("             2 - Listar todas as contas              ");
		System.out.println("             3 - Buscar conta por número             ");
		System.out.println("             4 - Atualizar dados da conta            ");
		System.out.println("             5 - Apagar conta                        ");
		System.out.println("             6 - Sacar                               ");
		System.out.println("             7 - Depositar                           ");
		System.out.println("             8 - Transferir valores entre contas     ");
		System.out.println("             9 - Sair                                ");
		System.out.println("                                                     ");
		System.out.println("-----------------------------------------------------");
		System.out.println(Cores.TEXT_WHITE
					       + "Digite a opção desejada:                             ");
		
		try {
		opcao = leia.nextInt();
		}catch(InputMismatchException e) {
			System.out.println("Digite valores inteiros!");
			leia.nextLine();
			opcao = 0;
		}
		
		switch(opcao) {
		case 1:
			System.out.println("                                                     ");
			System.out.println(Cores.TEXT_WHITE_BOLD
				               +  "                      Criar conta                    ");
			System.out.println(Cores.TEXT_WHITE
					           + "                                                     ");
			
			System.out.println("Digite o número da agência: ");
			agencia = leia.nextInt();
			
			System.out.println("Digite o nome do titular: ");
			leia.skip("\\R?");
			titular = leia.nextLine();
			
			do {
			System.out.println("Digite o tipo de conta (1- CC ou 2 - CP):");
			tipo = leia.nextInt();
			}while(tipo < 1 && tipo > 2);
			
			System.out.println("Digite o saldo da conta: ");
			saldo = leia.nextFloat();
			
			switch(tipo) {
			case 1:
				System.out.println("Digite o limite de crédito: ");
				limite = leia.nextFloat();
				contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
				break;
				
			case 2:
				System.out.println("Digite o dia de aniversário da conta: ");
				aniversario = leia.nextInt();
				contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
				break;
			}
			
			keyPress();
			break;
			
		case 2:
			System.out.println("                                                     ");
			System.out.println(Cores.TEXT_WHITE_BOLD 
					           + "                Listar todas as contas               ");
			System.out.println(Cores.TEXT_WHITE
					           + "                                                     ");
			contas.listarTodas();
			
			keyPress();
			break;
			
		case 3:
			System.out.println("                                                     ");
			System.out.println(Cores.TEXT_WHITE_BOLD 
					           + "               Buscar conta por número               ");
			System.out.println(Cores.TEXT_WHITE
					           + "                                                     ");
			System.out.println("Digite o número da conta: ");
			numero = leia.nextInt();
			
			contas.procurarPorNumero(numero);
			
			keyPress();
			break;
			
		case 4:
			System.out.println("                                                     ");
			System.out.println(Cores.TEXT_WHITE_BOLD 
					           + "               Atualizar dados da conta              ");
			System.out.println(Cores.TEXT_WHITE
					           + "                                                     ");
			System.out.println("Digite o número da conta: ");
			numero = leia.nextInt();
			if(contas.buscarNaCollection(numero) != null) {
				System.out.println("Digite o numero da agência: ");
				agencia = leia.nextInt();
				
				System.out.println("Digite o nome do titular: ");
				leia.skip("\\R?");
				titular = leia.nextLine();
				
				System.out.println("Digite o saldo da conta: R$");
				saldo = leia.nextFloat();
				
				tipo = contas.retornaTipo(numero);
				
				switch(tipo) {
				
				case 1 -> {
					System.out.println("Digite o limite de crédito: ");
					limite = leia.nextFloat();
					contas.atualizar(new ContaCorrente(numero,agencia,tipo,titular,saldo,limite));
				}
				case 2 -> {
					System.out.println("Digite o dia de aniversário da conta: ");
				aniversario = leia.nextInt();
				contas.atualizar(new ContaPoupanca(numero,agencia,tipo,titular,saldo,aniversario));
				}
				default ->{
					System.out.println("Tipo de conta inválido!");
				}
				}
				
			}else
				System.out.println("Conta não encontrada.");
			
			keyPress();
			break;
			
		case 5:
			System.out.println("                                                     ");
			System.out.println(Cores.TEXT_WHITE_BOLD 
					           + "                    Apagar conta                     ");
			System.out.println(Cores.TEXT_WHITE 
					           + "                                                     ");
			System.out.println("Digite o número da conta: ");
			numero = leia.nextInt();
			 contas.deletar(numero);
			
			 keyPress();
			break;
			
		case 6:
			System.out.println("                                                     ");
			System.out.println(Cores.TEXT_WHITE_BOLD 
					           + "                        Sacar                        ");
			System.out.println(Cores.TEXT_WHITE 
					           + "                                                     ");
			System.out.println("Digite o número da conta: ");
			numero = leia.nextInt();
			
			do {
				System.out.println("Digite o valor do saque: ");
				valor = leia.nextFloat();
			}while (valor <= 0);
			
			contas.sacar(numero, valor);
			
			keyPress();
			break;
			
		case 7:
			System.out.println("                                                     ");
			System.out.println(Cores.TEXT_WHITE_BOLD 
					           + "                      Depositar                      ");
			System.out.println(Cores.TEXT_WHITE 
					           + "                                                     ");
			System.out.println("Digite o número da conta: ");
			numero = leia.nextInt();
			
			do {
				System.out.println("Digite o valor do depósito: ");
				valor = leia.nextFloat();
			}while(valor <= 0);
			
			contas.depositar(numero, valor);

			keyPress();
			break;
			
		case 8:
			System.out.println("                                                     ");
			System.out.println(Cores.TEXT_WHITE_BOLD 
					           + "                 Transferir valores                  ");
			System.out.println(Cores.TEXT_WHITE
					           + "                                                     ");
			
			System.out.println("Digite o número da conta de origem: ");
			numero = leia.nextInt();
			
			System.out.println("Digite o número da conta de destino: ");
			numeroDestino = leia.nextInt();
			
			do {
				System.out.println("Digite o valor da transferência: ");
				valor = leia.nextFloat();
				
			}while(valor <= 0);
			
			contas.transferir(numero,numeroDestino,valor);
			
			keyPress();
			break;
			
		case 9:
			System.out.println("                                                     ");
			System.out.println(Cores.TEXT_RED_BOLD
					           + "                 Fechando o sistema...               ");
			System.out.println("                                                     ");
			System.exit(0);
			
			keyPress();
			break;
			
		default:
			System.out.println("                                                     ");
			System.out.println(Cores.TEXT_WHITE_BOLD 
					           + "                    Opção inválida.                  ");
			System.out.println("                    Tente novamente.                 ");
			System.out.println("                                                     ");
			keyPress();
			break;
			
		}
				}	
}

public static void keyPress() {
	try {
		System.out.println(Cores.TEXT_RESET + "\nPressione Enter para continuar...");
		System.in.read();
	}catch(IOException e) {
		System.out.println("Você pressionou uma tecla diferente de Enter.");
	}
}
}


