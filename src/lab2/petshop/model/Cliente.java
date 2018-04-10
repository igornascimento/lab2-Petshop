package lab2.petshop.model;

/**
 *
 * @author Igor Nascimento <igornascimento@gmail.com>
 */
public class Cliente {

    private Long rg;
    private String nome;
    private Long telefone;

    public Cliente() {
    }

	public Cliente(Long rg, String nome, Long telefone) {
		super();
		this.rg = rg;
		this.nome = nome;
		this.telefone = telefone;
	}

	public Long getRg() {
		return rg;
	}

	public void setRg(Long rg) {
		this.rg = rg;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}
    
}
