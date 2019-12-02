package principal;

import javax.swing.JOptionPane;
import modelo.Agenda;
import modelo.Contato;
import modelo.Endereco;

public class Main {

	public static void main(String[] args) {
		Agenda agenda = new Agenda();
		Contato contato;
		Endereco endereco;
		String nome;
		String numeroTelefone;
		String rua;
		String numeroCasa;
		String cep;
		String bairro;
		String dataNascimento;
		String nomeAtual; 
		int opcao = 0;


		while(true){


			try {
				opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "MENU:\n\n1. Inclusao do contato\n2. Alteracao de dados\n3. Exclusao do contato\n4. Consultar por nome\n5. Sair\n\nDigite a opcao:"));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Operacao cancelada!\nPrograma encerrado!");
				break;
			}			
			switch (opcao){

			case 1:
				while (opcao == 1) {

					nome = JOptionPane.showInputDialog(null, "Nome: ","Cadastro",JOptionPane.INFORMATION_MESSAGE);
					numeroTelefone = JOptionPane.showInputDialog(null, "Telefone: ","Cadastro",JOptionPane.INFORMATION_MESSAGE);

					while(agenda.verificarTelefoneExiste(numeroTelefone)) {
						numeroTelefone = JOptionPane.showInputDialog(null, "Por favor digite outro numero!","Cadastro",JOptionPane.INFORMATION_MESSAGE);	 
					}

					rua = JOptionPane.showInputDialog(null, "Rua: ","Cadastro",JOptionPane.INFORMATION_MESSAGE);
					numeroCasa = JOptionPane.showInputDialog(null, "Numero da casa: ","Cadastro",JOptionPane.INFORMATION_MESSAGE);
					bairro = JOptionPane.showInputDialog(null, "Bairro: ","Cadastro",JOptionPane.INFORMATION_MESSAGE);
					cep = JOptionPane.showInputDialog(null, "Cep: ","Cadastro",JOptionPane.INFORMATION_MESSAGE);
					dataNascimento = JOptionPane.showInputDialog(null, "Data de nascimento?","Cadastro",JOptionPane.INFORMATION_MESSAGE);
					endereco = new Endereco(rua, numeroCasa, bairro, cep); 
					contato = new Contato(nome, endereco, dataNascimento, numeroTelefone);
					agenda.adicionar(contato);
					JOptionPane.showMessageDialog(null, "Numero cadastrado!");
					opcao = Integer.parseInt(JOptionPane.showInputDialog(null,"Deseja efetuar outro cadastro?\n\n1. Sim\n2. Nao\n\nDigite sua opcao:"));
				}
				break;

			case 2:
				nome = JOptionPane.showInputDialog(null, "Informe o nome do contato que deseja alterar: ","Alterar",JOptionPane.INFORMATION_MESSAGE);

				if(agenda.verificarNomeExiste(nome) == false) {
					JOptionPane.showMessageDialog(null, "Contato nao foi encontrado!", "Aviso", JOptionPane.ERROR_MESSAGE);
					break;
				}

				nomeAtual = JOptionPane.showInputDialog(null, "Nome atual do contato: ","Alterar",JOptionPane.INFORMATION_MESSAGE);
				numeroTelefone = JOptionPane.showInputDialog(null, "Numero de telefone atual: ","Alterar",JOptionPane.INFORMATION_MESSAGE);
				rua = JOptionPane.showInputDialog(null, "Nome atual da rua: ","Alterar",JOptionPane.INFORMATION_MESSAGE);
				numeroCasa = JOptionPane.showInputDialog(null, "Informe o numero atual da casa: ","Alterar",JOptionPane.INFORMATION_MESSAGE);
				bairro = JOptionPane.showInputDialog(null, "Bairro atual: ","Alterar",JOptionPane.INFORMATION_MESSAGE);
				cep = JOptionPane.showInputDialog(null, "Cep atual: ","Alterar",JOptionPane.INFORMATION_MESSAGE);
				endereco = new Endereco(rua, numeroCasa, bairro, cep);
				agenda.alterar(nome, nomeAtual, endereco, numeroTelefone);

				break;

			case 3:
				nome = (JOptionPane.showInputDialog(null, "Informe o nome da pessoa que deseja excluir os dados: ","Excluir",JOptionPane.INFORMATION_MESSAGE));
				agenda.excluir(nome);

				break;

			case 4:
				nome = JOptionPane.showInputDialog(null, "Informe o nome da pessoa que deseja buscar:","Buscar",JOptionPane.INFORMATION_MESSAGE);
				agenda.buscar(nome);

				break;

			case 5:
				agenda.sair();

				break;

			default:
				JOptionPane.showMessageDialog(null, "OPCAO INVALIDA!", "AVISO",JOptionPane.INFORMATION_MESSAGE);

			}

		}
	}


}


