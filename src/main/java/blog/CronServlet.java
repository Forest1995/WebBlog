package blog;

import javax.mail.*;
import javax.mail.internet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.TimeZone;
import com.googlecode.objectify.ObjectifyService;

public class CronServlet extends HttpServlet{

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
  		
    	
    	//initialize a new message
        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);
        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("anything@enduring-plate-231504.appspotmail.com", "Today's Diaries"));
            SubscriptionServlet allEmails = new SubscriptionServlet();
            for (Subscriber subscriber : allEmails.getSubscription()) {
            	msg.addRecipient(Message.RecipientType.TO, new InternetAddress(subscriber.getEmail()));
            }
            //this part is for email content
            
            
            StringBuilder msgBody = new StringBuilder("<h2>Here are some interesting travel stories:</h2><br><hr>");
            Date date = new Date();
            String DATE_FORMAT = "MM/dd/yyyy";
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
            sdf.setTimeZone(TimeZone.getTimeZone("CST"));
            msg.setSubject(" Daily Digest: " + sdf.format(date));
            
            
            //to be changed
            BlogPostsServlet allPosts = new BlogPostsServlet();
            List<Post> results = allPosts.getRecentPosts();
            
            //can be changed
            Collections.sort(results, Collections.reverseOrder());
            for (Post post : results) {
			    msgBody.append("<h3>" + post.getTitle() + "</h3>\n");
			    msgBody.append("<p><i>Written by: " + post.getAuthor().getNickname().toString() + " on " + post.getDate().toString() + "</i></p>\n");
			    msgBody.append("<p>" + post.getContent() + "</p>\n");
		    	msgBody.append("<hr>");
            }
            msgBody.append("<h2>And those are all the updates for today, folks!</h2>");
            
            
            //send the email
            
            
            msg.setContent(msgBody.toString(), "text/html; charset=utf-8");
            Transport.send(msg);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
