package modelo;

public abstract class Pessoa {
	private String nome;
	private Endereco endereco;
	private String dataNascimento; 

	public Pessoa(String nome, Endereco endereco, String dataNascimento ) {
		this.nome = nome;
		this.endereco = endereco;
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

}
