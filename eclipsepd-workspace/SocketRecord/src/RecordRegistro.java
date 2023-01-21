import java.io.Serializable;

public class RecordRegistro implements Serializable {
	private String nome,indirizzo;
	
	public RecordRegistro(String n,String i) {
		nome=n;
		indirizzo=i;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getIndirizzo() {
		return indirizzo;
	}

}
