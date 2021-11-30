package productiveparameter.Kyselypalvelu.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class MonivalintaVaihtoehto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "kysymysid", referencedColumnName = "id")
	private Kysymys kysymys;

	private String monivalintavaihtoehto;

	public MonivalintaVaihtoehto() {
		super();
		this.monivalintavaihtoehto = null;
	}

	public MonivalintaVaihtoehto(String monivalintavaihtoehto) {
		super();
		this.monivalintavaihtoehto = monivalintavaihtoehto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Kysymys getKysymys() {
		return kysymys;
	}

	public void setKysymys(Kysymys kysymys) {
		this.kysymys = kysymys;
	}

	public String getMonivalintavaihtoehto() {
		return monivalintavaihtoehto;
	}

	public void setMonivalintavaihtoehto(String monivalintavaihtoehto) {
		this.monivalintavaihtoehto = monivalintavaihtoehto;
	}

	@Override
	public String toString() {
		return "MonivalintaVaihtoehto [monivalintavaihtoehto=" + monivalintavaihtoehto + "]";
	}

}
