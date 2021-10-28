package productiveparameter.Kyselypalvelu.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Questionnaire {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long questionnaireId;
	private String questionnaireName;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "questionnaire")
	private List<Question> questions;
	
	public Questionnaire(String name) {
		super();
		this.questionnaireName = name;
	}

	public Questionnaire() {
		super();
		this.questionnaireName = null;
	}

	public Long getId() {
		return questionnaireId;
	}

	public void setId(Long id) {
		this.questionnaireId = id;
	}

	public String getName() {
		return questionnaireName;
	}

	public void setName(String name) {
		this.questionnaireName = name;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "Questionnaire [name=" + questionnaireName + "]";
	}

}
