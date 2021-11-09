package productiveparameter.Kyselypalvelu.domain;

public class Vaihtoehto {
	
	private String vaihtoehto;

	public Vaihtoehto() {
		super();
		this.vaihtoehto = null;
	}

	public Vaihtoehto(String vaihtoehto) {
		super();
		this.vaihtoehto = vaihtoehto;
	}

	public String getVaihtoehto() {
		return vaihtoehto;
	}

	public void setVaihtoehto(String vaihtoehto) {
		this.vaihtoehto = vaihtoehto;
	}

	@Override
	public String toString() {
		return "Vaihtoehto [vaihtoehto=" + vaihtoehto + "]";
	}

}
