package productiveparameter.Kyselypalvelu_ilmanRESTia.domain;

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
   
    // Kyselylle tarvitaan id ja nimi
	private Long id;
	private String nimi;
	
	//lisätään kysymykset suoraan tähän tässä yksinkertaisessa ohjelmaversiossa)
	private String kysymys1;
	private String kysymys2;
	private String kysymys3;


	
	// Näitä voidaan käyttää myöhemmin, kun kysymykset lisätään erikseen-->
	
				// Yhdellä kyselylomakkeella voi olla monta kysymystä 
				@OneToMany(cascade = CascadeType.ALL, mappedBy = "kysely")
				
				//muodostetaan lista kyselyn sisältämistä kysymyksistä	
				private List<Kysymys> kysymykset;
	
	
	
	
	// konstruktorit
	public Kysely() {
		super();
		this.nimi = null;
		this.kysymys1 = null;
		this.kysymys2 = null;
		this.kysymys3 = null;
	}
	

	public Kysely(String nimi, String kysymys1, String kysymys2, String kysymys3 ) {
		super();
		this.nimi = nimi;
		this.kysymys1 = kysymys1;
		this.kysymys2 = kysymys2;
		this.kysymys3 = kysymys3;
    }


	
	// Tätä tarvitaan myöhemmin kun kysymykset on lisätty erikseen	ja ne kuuluvat tiettyyn kyselyyn
	// --> listataan kysymykset kyselyn perusteella
	public Kysely (String nimi, List<Kysely> kyselyt) {
		super();
		this.nimi = nimi;
		this.kysymys1 = kysymys1;
		this.kysymys2 = kysymys2;
		this.kysymys3 = kysymys3;
		this.kysymykset = kysymykset;
	}

	

	//getterit ja setterit 
	
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
	
	
	
////////////////////////////////////////////////////////
// getterit ja setterit kysymyksille	
	
	public String getKysymys1() {
		return kysymys1;
	}
	
	public String getKysymys2() {
		return kysymys2;
	}
	public String getKysymys3() {
		return kysymys3;
	}

	public void setKysymys1(String kysymys1) {
		this.kysymys1 = kysymys1;
	}
	public void setKysymys2(String kysymys2) {
		this.kysymys2 = kysymys2;
	}
	public void setKysymys3(String kysymys3) {
		this.kysymys3 = kysymys3;
	}
////////////////////////////////////////////////////////
	
	
	
	
	// haetaan lista kysymyksiä
	public List<Kysymys> getKysymykset() {
		return kysymykset;
	}

	public void setKysymykset(List<Kysymys> kysymykset) {
		this.kysymykset =  kysymykset;
	}


	

	@Override
	public String toString() {
		                                    
		return "Kysymys [id=" + id + ", nimi=" + nimi   + ", kysymys1=" + kysymys1   + ", kysymys2=" + kysymys2   + ", kysymys3=" + kysymys3   + "]";
		
	}
}


