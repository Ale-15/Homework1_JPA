package it.uniroma3.siw.model;

import javax.persistence.*;
import javax.persistence.CascadeType;

 @Entity
public class Societa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String ragioneSociale;
	@Column(nullable = false)
	private int telefono;

	public Societa() {
		
	}
	
	public Societa(long id, String ragioneSociale, int telefono) {
		this.id = id;
		this.ragioneSociale = ragioneSociale;
		this.telefono = telefono;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Societa");
		sb.append("{id =").append(id);
		sb.append(",ragioneSociale=").append(ragioneSociale);
		sb.append(",telefono=").append(telefono);
		sb.append("}\n");
		return sb.toString();
	}
	
	//La strategia di fetch Eager mi permette di caricare subito l'indirizzo della società ogni
	//volta che la carico, perché essendo una OneToOne il caricamento di una sola istanza non peserebbe.
	//Nel cascade il Persist e il Remove sono opportuni perché se rendo persistente o elimino una società,
	//voglio che accada anche per l'indirizzo, sopratutto essendo una OneToOne
	@OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private Indirizzo indirizzo;
}
