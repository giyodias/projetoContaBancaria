package conta;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		int opcao;
		
		
		do {
		System.out.println("-----------------------------------------------------");
		System.out.println("\n");
		System.out.println("               -BANCO DO BRAZIL COM Z-               ");
		System.out.println("\n");
		System.out.println("-----------------------------------------------------");
		System.out.println("\n");
		System.out.println("             1 - Criar conta                         ");
		System.out.println("             2 - Listar todas as contas              ");
		System.out.println("             3 - Buscar conta por número             ");
		System.out.println("             4 - Atualizar dados da conta            ");
		System.out.println("             5 - Apagar conta                        ");
		System.out.println("             6 - Sacar                               ");
		System.out.println("             7 - Depositar                           ");
		System.out.println("             8 - Transferir valores entre contas     ");
		System.out.println("             9 - Sair                                ");
		System.out.println("\n");
		System.out.println("-----------------------------------------------------");
		System.out.println("Digite a opção desejada: ");
		opcao = leia.nextInt();
		
		switch(opcao) {
		case 1:
			System.out.println("\n");
			System.out.println("                   Criar conta                   ");
			System.out.println("\n");
			break;
		case 2:
			System.out.println("\n");
			System.out.println("              Listar todas as contas             ");
			System.out.println("\n");
			break;
		case 3:
			System.out.println("\n");
			System.out.println("              Buscar conta por número            ");
			System.out.println("\n");
			break;
		case 4:
			System.out.println("\n");
			System.out.println("              Atualizar dados da conta           ");
			System.out.println("\n");
			break;
		case 5:
			System.out.println("\n");
			System.out.println("                   Apagar conta                  ");
			System.out.println("\n");
			break;
		case 6:
			System.out.println("\n");
			System.out.println("                       Sacar                     ");
			System.out.println("\n");
			break;
		case 7:
			System.out.println("\n");
			System.out.println("                     Depositar                   ");
			System.out.println("\n");
			break;
		case 8:
			System.out.println("\n");
			System.out.println("                 Transferir valores              ");
			System.out.println("\n");
			break;
		case 9:
			System.out.println("\n");
			System.out.println("              Fechando o sistema...              ");
			System.out.println("\n");
			System.exit(0);
			break;
		default:
			System.out.println("\n");
			System.out.println("                 Opção inválida.                 ");
			System.out.println("                 Tente novamente.                ");
			System.out.println("\n");
		}
		}while(opcao != 9);
		
		
		
		
		leia.close();
	}

}
