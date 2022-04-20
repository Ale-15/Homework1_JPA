package it.uniroma3.siw.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Corso {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;
		@Column(nullable = false)
		private String nome;
		@Column(nullable = false)
		private Date dataInizio;
		@Column(nullable = false)
		private int durata;

		public Corso() {
			
		}
		
		public Corso(long id, String nome, Date dataInizio, int durata) {
			this.id = id;
			this.nome = nome;
			this.dataInizio = dataInizio;
			this.durata = durata;
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

		public Date getDataInizio() {
			return dataInizio;
		}

		public void setDataInizio(Date dataInizio) {
			this.dataInizio = dataInizio;
		}

		public int getDurata() {
			return durata;
		}

		public void setDurata(int durata) {
			this.durata = durata;
		}
		
		public String toString() {
			final StringBuilder sb = new StringBuilder();
			sb.append("Allievi");
			sb.append("{id =").append(id);
			sb.append(",nome=").append(nome);
			sb.append(",dataInizio=").append(dataInizio);
			sb.append(",durata=").append(durata);;
			sb.append("}\n");
			return sb.toString();
		}
		
		@ManyToMany(fetch = FetchType.LAZY)
		private List<Allievo> allievi;
		
		//La strategia di fetch adatta è EAGER perché se carico il corso, voglio che mi si carica
		//subito anche il docente di tale corso. Per la politica di cascade il persist è oppurtuno perchè
		//se rendo persistente un corso, deve essere persistente anche il docente
		@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST})
		private Docente docente;
}
