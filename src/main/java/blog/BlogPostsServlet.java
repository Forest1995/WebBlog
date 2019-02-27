package blog;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import javax.servlet.http.*;
import static com.googlecode.objectify.ObjectifyService.ofy;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class BlogPostsServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();
		String title = req.getParameter("title");
		String author_email = user.getEmail();
		String content = req.getParameter("content");
		if (req.getParameter("title").isEmpty()) {
			// check for empty title
			resp.sendError(400, "No Title");
			return;
		} else if (req.getParameter("content").isEmpty()) {
			// checks for empty content
			resp.sendError(400, "No Content");
			return;
		} else {
			Post post = new Post(user, title, author_email, content);
			ofy().save().entities(post).now();
			resp.sendRedirect("/homepage.jsp");
		}
		resp.sendRedirect("/homepage.jsp");
	}

	// Retrieve entire post list - to display all posts
	public List<Post> getAllPosts() {
		List<Post> results = ofy().load().type(Post.class).list();
		Collections.sort(results);
		return results;
	}

	// Retrieve 5 latest posts - to display on homepage

	public List<Post> getFivePosts() {
		List<Post> allPosts = this.getAllPosts();
		int size = allPosts.size();
		if (size < 5)
			return allPosts;
		else
			return allPosts.subList(size - 5, size);
	}

	// Retrieve updated posts in the last 24 hours - to email

	public List<Post> getRecentPosts() {
		Date compareDate = new Date(System.currentTimeMillis() - 24 * 3600 * 1000);
		List<Post> results = new ArrayList<Post>();
		for (Post post : this.getAllPosts()) {
			if (post.getDate().after(compareDate)) {
				results.add(post);
			}
		}
		return results;
	}

}
