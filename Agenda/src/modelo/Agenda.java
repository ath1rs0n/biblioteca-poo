package modelo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Agenda {

	private ArrayList<Contato> contatos;

	public Agenda() {
		contatos = new ArrayList<>();
	}

	public void adicionar(Contato contato) {
		contatos.add(contato);
	}

	public boolean verificarTelefoneExiste(String numeroTelefone) {
		for(int i=0 ;i < contatos.size(); i++) {
			if(contatos.get(i).getNumeroTelefone().equals(numeroTelefone)) {
				JOptionPane.showMessageDialog(null, "Numero de Telefone ja existe!","Aviso",JOptionPane.ERROR_MESSAGE);
				return true;
			}

		}
		return false;
	}

	public void alterar(String nomeAnterior, String nomeAtual, Endereco endereco, String numeroTelefone) {

		if (contatos.size() > 0) {

			for(int i=0 ;i < contatos.size(); i++) {
				if(nomeAnterior.equalsIgnoreCase(contatos.get(i).getNome())) {
					contatos.get(i).setNome(nomeAtual);
					contatos.get(i).setNumeroTelefone(numeroTelefone);
					contatos.get(i).setEndereco(endereco);
					JOptionPane.showMessageDialog(null, "Contato alterado!");
				}	
			}

		}
	}

	public void buscar(String nome) {
		int acho = 0;
		if (contatos.size() > 0) {

			for(int i=0 ;i < contatos.size(); i++)
				if(nome.equalsIgnoreCase(contatos.get(i).getNome())) {

					acho = 1;

					JOptionPane.showMessageDialog(null, "REGISTRO ENCONTRADO:\n\nNome: " + contatos.get(i).getNome() + "\nTelefone: " + contatos.get(i).getNumeroTelefone() + "\nRua: " + contatos.get(i).getEndereco().getRua() + " \n Numero: "  + contatos.get(i).getEndereco().getNumeroCasa() + "\n Bairro: " + contatos.get(i).getEndereco().getBairro() + "\n Cep: " + contatos.get(i).getEndereco().getCep(), "\n Dados do Contato",JOptionPane.INFORMATION_MESSAGE);
				}
			if (acho==0){
				JOptionPane.showMessageDialog(null, "Nenhum registro foi encontrado!","Aviso",JOptionPane.ERROR_MESSAGE);
			}
		}
		else{
			JOptionPane.showMessageDialog(null, "Ainda nenhum cadastro foi realizado!","Aviso",JOptionPane.ERROR_MESSAGE);
		}
	}

	public void excluir(String nome) {
		int acho = 0, posicao = 0;

		if (contatos.size() > 0) {

			for(int i=0 ;i < contatos.size(); i++) {
				if(nome.equalsIgnoreCase(contatos.get(i).getNome())) {
					acho = 1;
					posicao = i; 
				}
			}
			if (acho==1){

				int confirmacao;
				confirmacao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir?","Excluir", JOptionPane.INFORMATION_MESSAGE);

				if(confirmacao == JOptionPane.CANCEL_OPTION) {
					JOptionPane.showMessageDialog(null, "Opera��o cancelada!");

				}

				if(confirmacao == 0) {
					contatos.remove(posicao);
					JOptionPane.showMessageDialog(null, "Contato excluido", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				}

			}else
				JOptionPane.showMessageDialog(null, "Contato nao encontrado!","Aviso",JOptionPane.ERROR_MESSAGE);
		}
		else{
			JOptionPane.showMessageDialog(null, "Ainda nenhum cadastro foi realizado!","Aviso",JOptionPane.ERROR_MESSAGE);
		}

	}

	public boolean verificarNomeExiste(String nome) {
		for(int i=0 ;i < contatos.size(); i++) {
			if(contatos.get(i).getNome().equals(nome)) {

				return true;
			}

		}
		return false;
	}

	public void sair(){

		JOptionPane.showMessageDialog(null, "Trabalho de POO, Professor Walker","Aviso",JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}
}

