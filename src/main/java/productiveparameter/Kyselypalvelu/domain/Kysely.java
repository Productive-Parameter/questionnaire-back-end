package productiveparameter.Kyselypalvelu.domain;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//Kyselylomakkeen kokonaisuus (entity)


@Entity
public class Kysely {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nimi;
	private String kuvaus;

//Yhdellä teemalla on monia sanoja (wordmap)
//Sanalla on yksi teema (tätä pitää kehittää sillä sanalla voi olla monta teemaa mutta ensin tehdään yksinkertaisemmin	
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "kysely")
	private List<Kysymys> kysymykset;
	
	public Kysely() {
		super();
		this.nimi = null;
		this.kuvaus = null;
		this.kysymykset = null;
	}
	
	public Kysely (String nimi, List<Kysymys> kysymykset) {
		super();
		this.nimi = nimi;
		this.kysymykset = kysymykset;
	}

	public Kysely (String nimi, String kuvaus, List<Kysymys> kysymykset) {
		super();
		this.nimi = nimi;
		this.kuvaus = kuvaus;
		this.kysymykset = kysymykset;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getNimi() {
		return nimi;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public String getKuvaus() {
		return kuvaus;
	}

	public void setKuvaus(String kuvaus) {
		this.kuvaus = kuvaus;
	}

	public List<Kysymys> getKysymykset() {
		return kysymykset;
	}

	public void setKysymykset(List<Kysymys> kysymykset) {
		this.kysymykset = kysymykset;
	}
	
	public int getKysymyksetSize() {
		return kysymykset.size();
	}

	@Override
	public String toString() {
		                                    
		return "Kysely [id=" +id + ", nimi=" + nimi   + "]";
		
	}
}
