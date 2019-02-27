# WebBlog
Objective. In this homework assignment, you will build your own web
app, completely from scratch. This will allow you put the skills you
learned from previous tutorials into practice. The goal is to make sure
you are comfortable with the tools and methods we will use throughout 
the semester.



Collaboration. This homework will be performed in teams of two.
The Assignment. In this homework, you will build a “blog” app on
Google AppEngine. You will submit a link to your working webapp, and
we will interact with that app to test your submission. To achieve a
perfect grade, you must meet all of these requirements:


Landing page: The link you submit should be of the form “http://
yourwebapp.appspot.com". This page should be nicely formatted. It
should include a header with at least one image that describes the blog,
separated visually from a set of the most recent blog entries. Each blog
entry should be displayed by displaying the title of the post (in some
different font than the body), the content of the post, the user who posted
it, and the date when it was posted. Look at some example blogs to see
how they’re generally formatted, if you’re not familiar. You don’t need
to be fancy with side panels and such. You need to do something
interesting with the look and feel of your blog, though. You could use an
external style sheet to define the style (change some colors, font styles,
etc.). Or you could go a step further and use an external tool, e.g.,
bootstrap (http://getbootstrap.com) or bootswatch (http://
bootswatch.com/). We recommend looking at blogs such as Medium
(https:// medium.com/).



Login: The landing page should have a place for the visitor to sign in
(using the Google Users Service). If a visitor is NOT signed in, he or she
should be allowed to view the blog posts but not create additional posts.
Posting: Once a visitor is logged in, he or she should be able to create a
new blog post. This means your page should have a link somewhere that
allows the visitor to create a new post, which will likely take him or her
to a new page. This page will have a place to enter a title of the blog post
and the content of a blog post (two differently sized, labeled text boxes
will suffice). You’ll also need a button that the user can click to “submit”
his or her new entry. Once the user clicks submit, he or she should be
taken back to the landing page, and the newest blog entry should be
displayed at the top of the list of entries. It probably wouldn’t hurt to
throw a Cancel button on that page as well, that allows the user to cancel
a started post. Reuse the style sheet that you use for the landing page so
that you get some uniformity among the pages. Posts should be persisted
in the datastore. You can use any method you like, including Objectify or
some other third party library.



Access to Posts: While the landing page should list the most recent
handful of posts (say 3-5), it should also be possible to access all posts
somehow. The easiest way to do this would be to allow the user to click
a link that says “List All Posts” or something similar and be taken to a
page that shows all posts on the blog, the most recent ones on top. You
are required to do at least this; you can choose to implement more
sophisticated browsing if you want (e.g., the “Previous Posts” and “Later
Posts” links you sometimes see on blogs).



A Cron Job: A What? A Cron job! You’re going to teach yourself how
to make your web app do something predefined on a regular schedule,
akin to cron in Unix. Your landing page should include a link that allows
a visitor to “subscribe.” Every day at 5pm Central Time, your app should
send (via email) a digest of any new posts in the last 24 hours to all
subscribed users. If there are no new posts, no email should be sent.
Your landing page should also include an unsubscribe link. We’re going
to subscribe to your blogs, but I really want to be able to unsubscribe, so
test this link HARD to make sure it works.
