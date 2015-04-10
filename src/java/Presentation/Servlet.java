/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Domain.Controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nicolaiharbo
 */
@WebServlet(name = "Control", urlPatterns = {"/Control"})
public class Servlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {

            Controller control = new Controller();

            //origin parameteret kommer fra den side du kommer fra, og smider dig ind i switchen,
            //og finder så det sted i switchen, som passer på det du beder om.
            String origin = request.getParameter("origin");

            switch (origin) {
                case "registration":

                    // Her gemmes teksten fra registration-formen, ned i strings, som så bliver tilføjet
                    // til et userobjekt.
                    String userid = request.getParameter("userid");
                    int partnerid = Integer.parseInt(request.getParameter("partnerid"));
                    String partnername = request.getParameter("partnername");
                    String address = request.getParameter("address");
                    int zip = Integer.parseInt(request.getParameter("zip"));
                    String city = request.getParameter("city");
                    int cvr = Integer.parseInt(request.getParameter("cvr"));
                    int phone = Integer.parseInt(request.getParameter("phone"));
                    String password = request.getParameter("password");
                    String re_password = request.getParameter("re_password");

                    control.addPartner(partnerid, partnername, address, zip, city, cvr, phone);
                    control.addUser(userid, password, re_password);

                    // "message" fanger den efterfølgende besked, som sendes med videre i et reguest til næste side.
                    // partnername er afhængig af, hvad der blev tastet ind i formularen
                    request.getSession().setAttribute("message", "You have succesfully created " + userid + " as a new partner.");

                    // response objektet sender dig videre til dashboardet, hvor den ovenstående "message" vises, afhængig af
                    // hvilken side du kommer fra.
                    response.sendRedirect("dashboard.jsp");
                    break;

                case "login":

                    //skriv et authCheck som kaldes igennem controlleren
                    String username = request.getParameter("username");

                    //Nedenstående afgør om det er Dell eller Partner dashboard som vises ved login. Dette skal nok skrivs ind i en auth i stedet
                    if (username.equalsIgnoreCase("Dell")) {
                        response.sendRedirect("dashboardDell.jsp");
                    } else {
                        response.sendRedirect("dashboardPartner.jsp");
                    }

                    request.getSession().setAttribute("message", "Welcome " + username + "!");

                    return;

                case "showCampaigns":
                    request.getSession().setAttribute("campaignList", control.getCampaign(campaignId));
                    response.sendRedirect("activeCampaigns.jsp");
                    return;

            }

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
