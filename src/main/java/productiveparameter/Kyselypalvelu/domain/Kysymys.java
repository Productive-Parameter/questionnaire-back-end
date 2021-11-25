package productiveparameter.Kyselypalvelu.domain;

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
public class Kysymys {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String teksti;
    private String tyyppi;
    private Boolean pakollinen;
    private Integer vaihtoehtomaara;

    
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "kyselyid", referencedColumnName = "id") 
    private Kysely kysely;
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kysymys")
    private List<KysymysVaihtoehto> vaihtoehdot;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kysymys")
    private List<MonivalintaVaihtoehdot> monivalintavaihtoehdot;
    
    public Kysymys() {
    	super();
    	this.teksti = null;
    	this.tyyppi = null;
    	this.kysely = null;
    	this.pakollinen = false;
    	this.vaihtoehtomaara = null;
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
	
	public Kysymys(String teksti, String tyyppi, Boolean pakollinen, Kysely kysely) {
		super();
		this.teksti = teksti;
		this.tyyppi = tyyppi;
		this.kysely = kysely;
		this.pakollinen = pakollinen;
	}	

	public Kysymys(Long id, String teksti, String tyyppi, Boolean pakollinen, Kysely kysely,
			List<KysymysVaihtoehto> vaihtoehdot) {
		super();
		this.id = id;
		this.teksti = teksti;
		this.tyyppi = tyyppi;
		this.pakollinen = pakollinen;
		this.kysely = kysely;
		this.vaihtoehdot = vaihtoehdot;
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

	public Integer getVaihtoehtomaara() {
		return vaihtoehtomaara;
	}

	public void setVaihtoehtomaara(Integer vaihtoehtomaara) {
		this.vaihtoehtomaara = vaihtoehtomaara;
	}

	public List<KysymysVaihtoehto> getVaihtoehdot() {
		return vaihtoehdot;
	}

	public void setVaihtoehdot(List<KysymysVaihtoehto> vaihtoehdot) {
		this.vaihtoehdot = vaihtoehdot;
	}

	public List<MonivalintaVaihtoehdot> getMonivalintavaihtoehdot() {
		return monivalintavaihtoehdot;
	}

	public void setMonivalintavaihtoehdot(List<MonivalintaVaihtoehdot> monivalintavaihtoehdot) {
		this.monivalintavaihtoehdot = monivalintavaihtoehdot;
	}

	@Override
	public String toString() {
		if (this.kysely != null)
			return "Kysymys [kysymysid=" + id + ", teksti=" + teksti + ", tyyppi=" + tyyppi + ", pakollinen=" + pakollinen + ", kysely =" + this.getKysely() + "]";		
		else
			return "Kysymys [kysymysid=" + id + ", teksti=" + teksti + ", tyyppi=" + tyyppi + ", pakollinen=" + pakollinen + "]";	
	}
}
