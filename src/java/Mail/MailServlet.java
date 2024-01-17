/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Mail;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import test.sendMail;

/**
 *
 * @author nguye
 */
public class MailServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String button = request.getParameter("btAction");

        String receiveMail = request.getParameter("txtMail");
        String name = request.getParameter("txtName");
        String capcha = request.getParameter("txtCapcha");

        String error_empty = "";
        
        
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        sendMail s = new sendMail();

        request.setAttribute("MAIL", receiveMail);
        request.setAttribute("NAME", name);

        // bấm nút 'Send' (gửi mã vào mail)
        if (button.equals("Send")) {
            if (receiveMail.isEmpty()) {
                error_empty = "No empty please.";
            } else {
                String otp = s.sendCapcha(receiveMail, name);
                session.setAttribute("CAPCHA", otp);
                // set thời gian active cho session của mã otp là 60s
                session.setMaxInactiveInterval(60);
//                request.getRequestDispatcher("check.jsp").forward(request, response);
            }

        // bấm nút 'Submit' (gửi form)
        } else if (button.equals("Submit")) {
            if (receiveMail.isEmpty() || name.isEmpty() || capcha.isEmpty()) {
                error_empty = "Enter capcha please.";
            } else {
                // lấy giá trị mã CAPCHA vừa được gửi về mail
                String temp = (String) request.getSession().getAttribute("CAPCHA");
                if(capcha.equals(temp)){
                    error_empty = "Dung ma";
//                    request.getRequestDispatcher("check.jsp").forward(request, response);
                }else{
                    error_empty = "Sai ma otp";
                }
//                request.getRequestDispatcher("check.jsp").forward(request, response);
            }
        }
        request.setAttribute("ERROR_EMPTY", error_empty);

        request.getRequestDispatcher("error_page.jsp").forward(request, response);
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
