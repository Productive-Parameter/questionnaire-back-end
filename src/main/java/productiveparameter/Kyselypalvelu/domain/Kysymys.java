package productiveparameter.Kyselypalvelu.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Kysymys {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String teksti;
    private String tyyppi;
    private Boolean pakollinen;

    
    @ManyToOne
    @JoinColumn(name = "kyselyid", referencedColumnName = "id") 
    private Kysely kysely;

    
    public Kysymys() {
    	super();
    	this.teksti = null;
    	this.tyyppi = null;
    	this.kysely = null;
    	this.pakollinen = false;
    }
    
    public Kysymys(String teksti) {
    	super();
    	this.teksti = teksti;
    	this.tyyppi = null;
    	this.kysely = null;
    	this.pakollinen = false;
    }
    
    public Kysymys(String teksti, Kysely kysely) {
		super();
		this.teksti = teksti;
		this.tyyppi = null;
		this.kysely = kysely;
		this.pakollinen = false;
	}	
  
	public Kysymys(String teksti, String tyyppi, Kysely kysely) {
		super();
		this.teksti = teksti;
		this.tyyppi = tyyppi;
		this.kysely = kysely;
		this.pakollinen = false;
	}
	
	public Kysymys(String teksti, String tyyppi, Kysely kysely, Boolean pakollinen) {
		super();
		this.teksti = teksti;
		this.tyyppi = tyyppi;
		this.kysely = kysely;
		this.pakollinen = pakollinen;
	}	

	public Long getId() {
		return id;
	}

	public void setId(Long kysymysid) {
		this.id = kysymysid;
	}

	public String getTeksti() {
		return teksti;
	}

	public void setTeksti(String teksti) {
		this.teksti = teksti;
	}

	public String getTyyppi() {
		return tyyppi;
	}

	public void setTyyppi(String tyyppi) {
		this.tyyppi = tyyppi;
	}

	public Kysely getKysely() {
		return kysely;
	}

	public void setKysely(Kysely kysely) {
		this.kysely = kysely;
	}

	public Boolean getPakollinen() {
		return pakollinen;
	}

	public void setPakollinen(Boolean pakollinen) {
		this.pakollinen = pakollinen;
	}

	@Override
	public String toString() {
		if (this.kysely != null)
			return "Kysymys [kysymysid=" + id + ", teksti=" + teksti + ", tyyppi=" + tyyppi + ", pakollinen=" + pakollinen + ", kysely =" + this.getKysely() + "]";		
		else
			return "Kysymys [kysymysid=" + id + ", teksti=" + teksti + ", tyyppi=" + tyyppi + ", pakollinen=" + pakollinen + "]";	
	}
}
