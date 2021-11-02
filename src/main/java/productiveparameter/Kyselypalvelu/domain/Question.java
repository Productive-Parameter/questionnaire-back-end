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
	private String questionContent;
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
		this.questionContent = null;
		this.type = null;
	}


	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getQuestionContent() {
		return questionContent;
	}

	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}

	public boolean isMandatory() {
		return mandatory;
	}

	public void setMandatory(boolean mandatory) {
		this.mandatory = mandatory;
	}

	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}

	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}

	@Override
	public String toString() {
		return "Question [type=" + type + ", questionContent=" + questionContent + ", mandatory=" + mandatory + "]";
	}	

}
