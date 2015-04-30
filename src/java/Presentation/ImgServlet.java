/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Domain.Controller;
import Domain.POE;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author nicolaiharbo
 */
@WebServlet(name = "ImgServlet", urlPatterns = {"/ImgServlet"})
public class ImgServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Controller controller = new Controller();

        // campaignid hentes ind fra active campaigns sidens dropdown.
        int id = Integer.parseInt(request.getParameter("campaignid"));
        
        // Objektet med det rigtige poe id hentes og gemmes i poe-variablen
        POE poe = controller.getPOE(id);

        // Billedet fra objektet hentes ud, og gemmes ned i en inputStream variabel.
        InputStream in = poe.getImage();
      
        //Her kan kun indlæses jpeg filer. Vi kunne godt lave en if-statement som checker hvilket filformt content er
        // så vi kan lave en if(jpeg) set contenttype image/jpeg, else if (pdf) setcontenttype..... bla bla..
        // Dette vil kræve at vi laver en tabel i databasen, som gemmer navnet på filformatet, hvor vi så
        // efterfølgende kan hente det ind, så vi ved hvilket format filen har, inden vi går ind i en if/else.
        response.setContentType("image/jpeg");
        
        //?? Hvad sker der her? Find ud af det :)
        OutputStream out = response.getOutputStream();
        byte[] buffer = new byte[1024];
        int counter = -1;
        

        while ((counter = in.read(buffer)) != -1) {
            out.write(buffer, 0, counter);
        }


    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
