package productiveparameter.Kyselypalvelu.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Vastaus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String vastaus;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "vaihtoehto" )
	private List<Vaihtoehto> monivalinta;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "kysymysid", referencedColumnName = "id") 
	private Kysymys kysymys;

	
	public Vastaus() {
		super();
		this.vastaus = null;
		this.monivalinta = new ArrayList<Vaihtoehto>();
		this.kysymys = null;
	}

	public Vastaus(String vastaus, Kysymys kysymys) {
		super();
		this.vastaus = vastaus;
		this.monivalinta = new ArrayList<Vaihtoehto>();
		this.kysymys = kysymys;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVastaus() {
		return vastaus;
	}

	public void setVastaus(String vastaus) {
		this.vastaus = vastaus;
	}

	public Kysymys getKysymys() {
		return kysymys;
	}

	public void setKysymys(Kysymys kysymys) {
		this.kysymys = kysymys;
	}
	
	public List<Vaihtoehto> getMonivalinta() {
		return monivalinta;
	}

	public void setMonivalinta(List<Vaihtoehto> monivalinta) {
		this.monivalinta = monivalinta;
	}

	@Override
	public String toString() {
		return "Vastaus [id=" + id + ", vastaus=" + vastaus + ", kysymys=" + kysymys
				+ "]";
	}
	
	
}
