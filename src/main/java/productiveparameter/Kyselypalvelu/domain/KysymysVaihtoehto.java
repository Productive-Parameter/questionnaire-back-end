package productiveparameter.Kyselypalvelu.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class KysymysVaihtoehto extends Vaihtoehto{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "kysymysid", referencedColumnName = "id")
	private Kysymys kysymys;

	public KysymysVaihtoehto() {
		super();
		this.kysymys = null;
	}

	public KysymysVaihtoehto(String vaihtoehto, Kysymys kysymys) {
		super(vaihtoehto);
		this.kysymys = kysymys;
	}

	public Object getKysymys() {
		return kysymys;
	}

	public void setKysymys(Kysymys kysymys) {
		this.kysymys = kysymys;
	}

	@Override
	public String toString() {
		return super.toString() + ", kysymys=" + kysymys + "]";
	}
}
