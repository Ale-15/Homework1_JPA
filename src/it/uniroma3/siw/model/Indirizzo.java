package it.uniroma3.siw.model;

import javax.persistence.*;

@Entity
public class Indirizzo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String via;
	@Column(nullable = false)
	private int numeroCivico;
	@Column(nullable = false)
	private String comune;
	@Column(nullable = false)
	private int cap;
	@Column(length = 2000)
	private String provincia;

	public Indirizzo() {
		
	}
	
	public Indirizzo(long id, String via, int numeroCivico, String comune, int cap, String provincia) {
		this.id = id;
		this.via = via;
		this.numeroCivico = numeroCivico;
		this.comune = comune;
		this.cap = cap;
		this.provincia = provincia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public int getNumeroCivico() {
		return numeroCivico;
	}

	public void setNumeroCivico(int numeroCivico) {
		this.numeroCivico = numeroCivico;
	}

	public String getComune() {
		return comune;
	}

	public void setComune(String comune) {
		this.comune = comune;
	}

	public int getCap() {
		return cap;
	}

	public void setCap(int cap) {
		this.cap = cap;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Indirizzo");
		sb.append("{id =").append(id);
		sb.append(",via=").append(via);
		sb.append(",numeroCivico=").append(numeroCivico);
		sb.append(",comune=").append(comune);
		sb.append(",cap=").append(cap);
		sb.append(",provincia=").append(provincia);
		sb.append("}\n");
		return sb.toString();
	}
}
