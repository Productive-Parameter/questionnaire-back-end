package productiveparameter.Kyselypalvelu.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class VastausVaihtoehto extends Vaihtoehto{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "vastausid", referencedColumnName = "id")
	private Vastaus vastaus;

	public VastausVaihtoehto() {
		super();
	}

	public VastausVaihtoehto(String vaihtoehto, Vastaus vastaus) {
		super(vaihtoehto);
		this.vastaus = vastaus;
	}

	public Object getVastaus() {
		return vastaus;
	}

	public void setVastaus(Vastaus vastaus) {
		this.vastaus = vastaus;
	}

	@Override
	public String toString() {
		return super.toString() + ", vastaus=" + vastaus + "]";
	}
	
}
