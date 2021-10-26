package productiveparameter.Kyselypalvelu.domain;

public class Question {
	
	private Long id;
	private String type;
	private boolean mandatory;
	
	public Question(String type, boolean mandatory) {
		super();
		this.type = type;
		this.mandatory = mandatory;
	}

	public Question() {
		super();
		this.type = null;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isMandatory() {
		return mandatory;
	}

	public void setMandatory(boolean mandatory) {
		this.mandatory = mandatory;
	}

	@Override
	public String toString() {
		return "Question [type=" + type + ", mandatory=" + mandatory + "]";
	}
	

}
