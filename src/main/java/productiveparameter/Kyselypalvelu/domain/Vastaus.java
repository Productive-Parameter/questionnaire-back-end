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
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "vastaus" )
	private List<VastausVaihtoehto> vaihtoehdot;
	
	@ManyToOne
    @JsonIgnore
    @JoinColumn(name = "kyselyid", referencedColumnName = "id") 
    private Kysely kysely;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "kysymysid", referencedColumnName = "id") 
	private Kysymys kysymys;

	
	public Vastaus() {
		super();
		this.vastaus = null;
		this.vaihtoehdot = new ArrayList<VastausVaihtoehto>();
		this.kysymys = null;
	}

	public Vastaus(String vastaus, Kysymys kysymys) {
		super();
		this.vastaus = vastaus;
		this.vaihtoehdot = new ArrayList<VastausVaihtoehto>();
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
	
	public Kysely getKysely() {
		return kysely;
	}

	public void setKysely(Kysely kysely) {
		this.kysely = kysely;
	}

	public List<VastausVaihtoehto> getVaihtoehdot() {
		return vaihtoehdot;
	}

	public void setVaihtoehdot(List<VastausVaihtoehto> vaihtoehdot) {
		this.vaihtoehdot = vaihtoehdot;
	}

	@Override
	public String toString() {
		return "Vastaus [id=" + id + ", vastaus=" + vastaus + ", kysymys=" + kysymys
				+ "]";
	}
	
	
}
