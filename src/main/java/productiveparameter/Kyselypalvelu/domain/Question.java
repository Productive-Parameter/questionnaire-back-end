package productiveparameter.Kyselypalvelu.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long questionId;
	private String type;
	private boolean mandatory;
	
	@ManyToOne
	@JoinColumn(name = "questionnaireId")
	private Questionnaire questionnaire;
	
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
		return questionId;
	}

	public void setId(Long id) {
		this.questionId = id;
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
