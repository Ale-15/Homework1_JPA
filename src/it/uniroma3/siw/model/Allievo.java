package it.uniroma3.siw.model;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
public class Allievo {

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
	@Column(nullable = false)
	private int matricola;
	@Column
	private String email;

	public Allievo() {
		
	}
	
	public Allievo(long id, String nome, String cognome, Date dataNascita, String luogo, int matricola, String email) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.luogo = luogo;
		this.matricola = matricola;
		this.email = email;
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

	public int getMatricola() {
		return matricola;
	}

	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Allievi");
		sb.append("{id =").append(id);
		sb.append(",nome=").append(nome);
		sb.append(",cognome=").append(cognome);
		sb.append(",dataNascita=").append(dataNascita);
		sb.append(",luogo=").append(luogo);
		sb.append(",matricola=").append(matricola);
		sb.append(",email=").append(email);
		sb.append("}\n");
		return sb.toString();
	}
	
	//La strategia di fetch Lazy mi permette di non dover caricare tutti i corsi alla quale
	//l'alunno partecipa ogni volta che carico l'alunno, renderebbe il caricamento più lento
	@ManyToMany(mappedBy = "allievi", fetch = FetchType.LAZY)
	private List<Corso> corsi;
	
	//La strategia di fetch EAGER mi permette di caricare subito la società di cui fa parte l'allievo
	//appena caricato. Il PERSIST nella strategia di cascade mi permette di rendere persistente la società quando
	//rendo persistente l'allievo
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST})
	private Societa societa;
}
