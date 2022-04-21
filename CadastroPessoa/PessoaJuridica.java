package TesteComHerança;

public class PessoaJuridica extends Pessoa {
	String cnpj;

	public String getCnpj() {
		return cnpj;
	}
	
	public PessoaJuridica (String nome, String cnpj) {
		this.nome = nome;
		this.cnpj = cnpj;
	}
}
