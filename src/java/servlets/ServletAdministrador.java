
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletAdministrador extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ServletContext contexto = getServletContext();
        RequestDispatcher rd;
        
        try{
            String numero = request.getParameter("numero");
            String color = request.getParameter("color");
            int num = Integer.parseInt(numero);
            if(num>=1 && num <=9 && esValidoColor(color)){
                contexto.setAttribute("numero_valido", numero);
                contexto.setAttribute("color_valido", color);
                rd=contexto.getRequestDispatcher("/ServletTabla");
                rd.forward(request, response);
            }else{
                if(!esValidoColor(color)){
                    rd=contexto.getRequestDispatcher("/ErrorColor.html");
                    rd.forward(request, response);
                }else{
                    rd=contexto.getRequestDispatcher("/ErrorNumero.html");
                    rd.forward(request, response);
                }
            }
            
        }catch(NumberFormatException e){
            rd=contexto.getRequestDispatcher("/ErrorNumero.html");
            rd.forward(request, response);
        }
    }

    private boolean esValidoColor(String color) {
        String[] colores= {"red","yellow","green","blue","pink","black","orange"};
        boolean encontrado = false;
        for(int x=0; x<colores.length && !encontrado; x++){
            if(colores[x].equalsIgnoreCase(color)) encontrado = true;
        }
        return encontrado;
    }   

}
