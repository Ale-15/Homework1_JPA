package it.uniroma3.siw.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Docente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String cognome;
	@Column(nullable = false)
	private Date dataNascita;
	@Column(nullable = false)
	private String luogo;
	@Column(length = 2000)
	private float partitaIva;

	public Docente() {
		
	}
	
	public Docente(long id, String nome, String cognome, Date dataNascita, String luogo, float partitaIva) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.luogo = luogo;
		this.partitaIva = partitaIva;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public Date getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}
	public String getLuogo() {
		return luogo;
	}
	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}
	public float getPartitaIva() {
		return partitaIva;
	}
	public void setNumIva(float partitaIva) {
		this.partitaIva = partitaIva;
	}

	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Docente");
		sb.append("{id =").append(id);
		sb.append(",nome=").append(nome);
		sb.append(",cognome=").append(cognome);
		sb.append(",dataNascita=").append(dataNascita);
		sb.append(",luogo=").append(luogo);
		sb.append(",partitaIva=").append(partitaIva);
		sb.append("}\n");
		return sb.toString();
	}
	
	//La strategia di fetch migliore è il Lazy perché se carico il docente, non voglio che
	//mi si caricano subito i suoi corsi, perché renderebbe la transazione più lenta
	@OneToMany(mappedBy = "docente", fetch = FetchType.LAZY)
	private List<Corso> corsiSeguiti;
}
