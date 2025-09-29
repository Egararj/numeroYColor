
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
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
        
        ServletContext  contexto = getServletContext();
        RequestDispatcher rd;
        
        try{
            String numero = request.getParameter("numero");
            String color = request.getParameter("color");
            int num = Integer.parseInt(numero);
            if(num>=1 &&num <=9 && esValidoColor(color)){
                
            }
            
        }catch(NumberFormatException e){
            
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
