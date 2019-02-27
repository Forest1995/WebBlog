package blog;

import com.googlecode.objectify.ObjectifyService;


import javax.servlet.http.HttpServlet;


public class OfyBlog extends HttpServlet {

// this class is to avoid repeated registering
	static {
        ObjectifyService.register(Post.class);
        ObjectifyService.register(Subscriber.class);
    }
}
