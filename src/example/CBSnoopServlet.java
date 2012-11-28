package example;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Hello world!
 *
 */
public class CBSnoopServlet extends HttpServlet
{
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException
    {
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        pw.println("System Properties");
        pw.println("<table>");
        TreeMap<String, String> map = new TreeMap<String, String>();
        Properties props = System.getProperties();
        for(Object nameObj : props.keySet()) {
            String name = (String)nameObj;
            String val = props.getProperty(name);
            map.put(name, val);
        }
        
        for(String name : map.keySet()) {
            String val = props.getProperty(name);
            pw.println(String.format("<tr><td>%s</td><td>%s</td></tr>", name, val));
        }
        pw.println("</table>");
    }
}
