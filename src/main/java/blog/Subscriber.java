package blog;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Subscriber{
	@Id String id;
	public String email;
	
	private Subscriber() {}
	public Subscriber(String email) {
		this.id=email;
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
}
