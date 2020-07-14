import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ResumeServlet", urlPatterns = "/resume")
public class ResumeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String content = "<h1>My Resume</h1>";
        content += "<p>I write a lot of code. Check my GitHub</p>";
        content += "<hr><br>";
        content += "<a href='https://github.com/'>My GitHub Profile</a><br>";
        content += "<a href='/portfolio'>My Portfolio</a>";

        PrintWriter out = response.getWriter();
        out.println(content);
    }
}
