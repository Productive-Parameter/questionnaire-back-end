package productiveparameter.Kyselypalvelu.domain;

import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Vaihtoehto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String vaihtoehto;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "vastausid", referencedColumnName = "id")
	private Optional<Object> vastaus;

	public Vaihtoehto() {
		super();
		this.vaihtoehto = null;
		this.vastaus = null;
	}

	public Vaihtoehto(String vaihtoehto, Optional<Object> object) {
		super();
		this.vaihtoehto = vaihtoehto;
		this.vastaus = object;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVaihtoehto() {
		return vaihtoehto;
	}

	public void setVaihtoehto(String vaihtoehto) {
		this.vaihtoehto = vaihtoehto;
	}

	public Optional<Object> getVastaus() {
		return vastaus;
	}

	public void setVastaus(Optional<Object> object) {
		this.vastaus = object;
	}

	@Override
	public String toString() {
		return "Vaihtoehto [id=" + id + ", vaihtoehto=" + vaihtoehto + ", vastaus=" + vastaus + "]";
	}
	
}
