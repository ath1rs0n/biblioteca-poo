package modelo;


public class Contato extends Pessoa {
	private String numeroTelefone; 

	public Contato(String nome, Endereco endereco, String dataNascimento) {
		super(nome, endereco, dataNascimento);

	}
	public Contato(String nome, Endereco endereco, String dataNascimento, String numeroTelefone) {
		super(nome, endereco, dataNascimento);
		this.numeroTelefone = numeroTelefone;
	}
	public String getNumeroTelefone() {
		return numeroTelefone;
	}
	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public String getDataNascimento() {
		return "Data Nascimento: " + super.getDataNascimento();

	}

}
