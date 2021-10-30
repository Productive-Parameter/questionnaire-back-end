package productiveparameter.Kyselypalvelu_rest.domain;

import java.util.Objects;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonIgnore;

// tätä käytetään myöhemmin kun kysymykset yhdistetään Kyselyyn (nyt kysymykset lisätään kiinteästi kyselyssä)

@Entity
public class Kysymys {
	
 
	@Id 
	@GeneratedValue (strategy=GenerationType.AUTO)
	
	private Long id;
	private String teksti;

	
    @ManyToOne //yhdellä kyselyllä on monta kysymystä
	@JsonIgnore
	@JoinColumn(name = "kyselyid") 
	private Kysely kysely;

	  
	public Kysymys() {}
	

	public Kysymys(String teksti) {
		super();
		this.teksti = teksti;
		this.kysely = kysely;
	
	}


	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

	public String getTeksti() {
		return teksti;
	}

	public void setTeksti(String teksti) {
		this.teksti = teksti;
	}
	

	public void setTheme(Kysely kysely) {
		this.kysely = kysely;
	}
	
	public Kysely getKysely() {
		return kysely;
	}

	@Override
	public String toString() {
		if (this.kysely != null)
			return "Kysymys [id=" + id + ", kysymys=" + teksti +  ", theme =" + this.getKysely() + "]";		
		else
			return "Kysymys [id=" + id + ", kysymys=" + teksti  + "]";	
	}
	

}