/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import DataSource.DBfacade;
import Domain.Controller;
import Domain.Partner;
import Domain.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

        //Nedenstående opretter en session, hvis der ikke allerede findes en.
        request.getSession(true);
        Controller control;

        //Hvis control-attributten er tom, oprettes en ny controller,
        // hvis der findes en controller i forvejen (else), bruges denne.
        // Dette er for at der ikke oprettes flere controllere under samme session,
        // da der ellers vil gå data tabt, hver gang der oprettes en ny controller.
        if (request.getSession().getAttribute("control") == null) {
            control = new Controller();
            request.getSession().setAttribute("control", control);
        } else {
            control = (Controller) request.getSession().getAttribute("control");
        }

        try (PrintWriter out = response.getWriter()) {

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
                    int cvr = Integer.parseInt(request.getParameter("cvr"));
                    int phone = Integer.parseInt(request.getParameter("phone"));
                    int zip = Integer.parseInt(request.getParameter("zip"));
                    String password = request.getParameter("password");
                    String re_password = request.getParameter("re_password");

                    control.addUser(userid, password);
                    control.addPartner(userid, partnerid, partnername, address, cvr, phone, zip);

                    // "message" fanger den efterfølgende besked, som sendes med videre i et reguest til næste side.
                    // partnername er afhængig af, hvad der blev tastet ind i formularen
                    request.getSession().setAttribute("message", "You have succesfully created " + userid + " as a new partner.");

                    // response objektet sender dig videre til dashboardet, hvor den ovenstående "message" vises, afhængig af
                    // hvilken side du kommer fra.
                    response.sendRedirect("dashboardDell.jsp");
                    break;

                case "login":

                    //skriv et authCheck som kaldes igennem controlleren her.
//                    String username = request.getParameter("username");
                    //Nedenstående afgør om det er Dell eller Partner dashboard som vises ved login. Dette skal nok skrivs ind i en auth i stedet
//                    if (username.equalsIgnoreCase("Dell")) {
//                        response.sendRedirect("dashboardDell.jsp");
//                    } else {
//                        response.sendRedirect("dashboardPartner.jsp");
//                    }
//                    request.getSession().setAttribute("message", "Welcome " + username + "!");
                    try {
                        User user = new User();
                        String username = request.getParameter("username");
                        user.setUserId(request.getParameter("username"));
                        user.setPassword(request.getParameter("password"));
                        user = DBfacade.login(user);
                        if (user.isValid()) {
                            HttpSession session = request.getSession(true);
                            session.setAttribute("message", user);

                            // I tilfælde af del login.
                            if (username.equalsIgnoreCase("Dell")) {
                                response.sendRedirect("dashboardDell.jsp"); //logged-in page for Dell 
                            } else if (username.equalsIgnoreCase("Elgiganten100") || username.equalsIgnoreCase("Elgiganten200")) { // I tilfælde af partner login. 
                                response.sendRedirect("dashboardPartner.jsp");
                            }

                        } else {
                            response.sendRedirect("invalidLogin.jsp"); //error page 

                        }
                    } catch (Exception e) {
                    }

                    return;

                case "showActiveCampaigns":
                    request.getSession().setAttribute("campaignList", control.getAllCampaigns());
                    response.sendRedirect("activeCampaigns.jsp");
                    return;

                case "showPartnerCampaigns":
                    String user = request.getParameter("username");
                    request.getSession().setAttribute("partnercampaigns", control.getPartnerCampaigns(user));

                    response.sendRedirect("PartnerCampaigns.jsp");
                    return;

                case "showPartners":
                    request.getSession().setAttribute("partnerList", control.getAllPartners());
                    response.sendRedirect("showPartner.jsp");
                    return;

                case "deletePartner":
                    String user_idDelete = request.getParameter("useridDelete");
                    // lav som boolean, så der kan gives feedback på, om det er gået godt eller ej.
                    control.deletePartner(user_idDelete);
                    request.getSession().setAttribute("message", "You have succesfully deleted " + user_idDelete + " as a partner.");
                    response.sendRedirect("dashboardDell.jsp");
                    return;

                case "editPartnerPage":
                    String user_idEdit = request.getParameter("useridEdit");
                    request.getSession().setAttribute("partner", control.getPartner(user_idEdit));
                    response.sendRedirect("editPartner.jsp");
                    break;

                case "editPartnerDB":
                    String useridEdit = request.getParameter("userid");
                    int partneridEdit = Integer.parseInt(request.getParameter("partnerid"));
                    String partnernameEdit = request.getParameter("partnername");
                    String addressEdit = request.getParameter("address");
                    int cvrEdit = Integer.parseInt(request.getParameter("cvr"));
                    int phoneEdit = Integer.parseInt(request.getParameter("phone"));
                    int zipEdit = Integer.parseInt(request.getParameter("zip"));
                    //String password = request.getParameter("password");
                    //String re_password = request.getParameter("re_password");

                    //control.editUser(userid, password);
                    control.editPartner(new Partner(useridEdit, partneridEdit, partnernameEdit, addressEdit, cvrEdit, phoneEdit, zipEdit));

                    request.getSession().setAttribute("message", "You have succesfully edited " + useridEdit);
                    response.sendRedirect("dashboardDell.jsp");
                    break;

                case "campaignRequest":
                    Date startDate = Date.valueOf(request.getParameter("startDate"));
                    Date stopDate = Date.valueOf(request.getParameter("stopDate"));
                    int budget = Integer.parseInt(request.getParameter("budget"));
                    String country = request.getParameter("country");
                    int campaignId = Integer.parseInt(request.getParameter("campaignId"));//Campaign id skal countes, så den selv finder et ledigt nummer.
                    int partnerId = Integer.parseInt(request.getParameter("partnerId"));//Denne skal autoudfyldes.
                    //Status fastlåst til "Pending" her, fordi det er et request, som skal godkendes, og derefter ændres status.
                    String status = "pending";
                    //String campaignType = ...
                    //String comment = request.getParameter("comment");
                    //System.out.println("Startdate: " + startDate + " - stopdate: " + stopDate);
                    control.addCampaign(campaignId, partnerId, startDate, stopDate, budget, status, country);

                    request.getSession().setAttribute("message", "You have succesfully requested a new campaign");
                    response.sendRedirect("dashboardPartner.jsp");
                    break;

                case "awaitingRequests":
                    request.getSession().setAttribute("campaignReqList", control.getCampaignRequests());
                    response.sendRedirect("awaitingRequests.jsp");
                    break;

                case "acceptCampaignRequest":
                    int accept_c_id = Integer.parseInt(request.getParameter("acceptCampaignid"));
                    control.acceptCampaignRequest(accept_c_id);
                    request.getSession().setAttribute("message", "You have succesfully accepted the request");
                    response.sendRedirect("dashboardDell.jsp");
                    break;

                case "disapproveCampaignRequest":
                    int disapprove_c_id = Integer.parseInt(request.getParameter("disapproveCampaignid"));
                    control.disapproveCampaignRequest(disapprove_c_id);
                    request.getSession().setAttribute("message", "You have succesfully disapproved the request!");
                    response.sendRedirect("dashboardDell.jsp");
                    break;

                case "showInactiveCampaigns":
                    request.getSession().setAttribute("disCampaignList", control.getDisapprovedCampaigns());
                    response.sendRedirect("disapprovedCampaigns.jsp");
                    break;

                case "clearDisapproved":
                    control.clearDisapprovedCampaigns();
                    request.getSession().setAttribute("message", "You have succesfully cleared the list of disapproved campaigns!");
                    response.sendRedirect("dashboardDell.jsp");
                    break;

                case "POEUpload":
                    String POEID = request.getParameter("POEID");
                    int POE_C_ID = Integer.parseInt(request.getParameter("CampaignID"));
                    String POEimg = request.getParameter("POEFile");
                    String PStatus = "Pending";

                    control.addPoe(POEID, POE_C_ID, PStatus, POEimg);
                    request.getSession().setAttribute("message", "You have succesfully sent your POE ");
                    response.sendRedirect("dashboardPartner.jsp");
                    break;

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
