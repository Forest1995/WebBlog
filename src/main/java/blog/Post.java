package blog;

import java.util.Date;
import com.google.appengine.api.users.User;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Post implements Comparable<Post> {
	@Id Long id;
	User author;
	String title;
	String author_email;
	String content;
	Date date;
	private Post() {}
	public Post(User author, String title, String author_email, String content) {
		this.author = author;
		this.title = title;
		this.author_email = author_email;
		this.content = content;
		this.date = new Date();
	}
	public String getTitle() {
		return title;
	}
	public User getAuthor() {
		return author;
	}
	public String getContent() {
		return content;
	}
	public Date getDate() {
		return date;
	}
//rewrite
	@Override
	public int compareTo(Post other) {
		return date.compareTo(other.date);
	}

}