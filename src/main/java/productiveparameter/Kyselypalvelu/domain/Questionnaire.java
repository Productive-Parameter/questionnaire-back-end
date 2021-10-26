package productiveparameter.Kyselypalvelu.domain;

import java.util.List;

public class Questionnaire {
	
	private Long id;
	private String name;
	private List<Question> questions;
	
	public Questionnaire(String name) {
		super();
		this.name = name;
	}

	public Questionnaire() {
		super();
		this.name = null;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "Questionnaire [name=" + name + "]";
	}

}
