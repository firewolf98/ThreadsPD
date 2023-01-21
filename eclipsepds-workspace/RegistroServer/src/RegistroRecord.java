import java.io.Serializable;

public class RegistroRecord implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nome;
	private String indirizzo;
	
	public RegistroRecord(String nome, String indirizzo) {
		super();
		this.nome = nome;
		this.indirizzo = indirizzo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	
}
