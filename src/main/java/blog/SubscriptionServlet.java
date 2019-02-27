package blog;

import static com.googlecode.objectify.ObjectifyService.ofy;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.googlecode.objectify.ObjectifyService;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class SubscriptionServlet extends HttpServlet {
	// Add a subscriber
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();
		if (req.getParameter("email") != null) {
			String email = req.getParameter("email");
			ofy().save().entity(new Subscriber(email)).now();
		} else {
			resp.sendError(400, "You didn't specify an email!");
			return;
		}
		resp.sendRedirect("/homepage.jsp");
	}

	// to be deleted
	public List<Subscriber> getSubscription() {
		return ofy().load().type(Subscriber.class).list();
	}
}
