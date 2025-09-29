
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletTabla extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String num=(String) getServletContext().getAttribute("numero_valido");
        int numero = Integer.parseInt(num);
        String color =(String) getServletContext().getAttribute("color_valido");
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Document</title>");
        out.println("</head>");
        out.println("<body text="+color+">");
        out.println("<h1>Tabla de multiplicar del "+numero+"</h1>");
        out.println("<table>");
        for(int x=1; x<10; x++){
            out.println("<tr><td>"+numero+"</td><td> x = </td><td>"+numero*x+"</td></tr>");
        }
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
