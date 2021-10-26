package productiveparameter.Kyselypalvelu.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Question {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long id;
	public String type;
	
	
	public Question(Long id, String type) {
		super();
		
		this.id = id;
		this.type = type;
	}
	

	public Question(String type) {
		super();
		this.type = type;
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



	@Override
	public String toString() {
		return "Question [type=" + type + ", mandatory=";
	}
	

}
