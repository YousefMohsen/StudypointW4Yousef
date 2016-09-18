/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Data.DB;
import entity.Book;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import newController.NewController;

/**
 *
 * @author Yousinho
 */
@WebServlet(name = "NewServlet", urlPatterns = {"/NewServlet"})
public class NewServlet extends HttpServlet {
NewController con = new NewController(); 

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");


        try (PrintWriter out = response.getWriter()) {
           
            String origin = request.getParameter("origin");
            
            String title = request.getParameter("title");
            String author = request.getParameter("author");
            int pages =  Integer.parseInt(request.getParameter("pages"));
            int price =  Integer.parseInt(request.getParameter("price"));
                      HttpSession session = request.getSession();
                      session.setAttribute("booksToString", con.bookListToString());

            switch(origin){
           
               case "addNewBook":

                 con.addBook(new Book(title,author,pages,price));

                      session.setAttribute("bookList", con.getBooks());
                      session.setAttribute("booksToString", con.bookListToString());
                      
                      
                      //save new book to database

                        String sql = "INSERT INTO books (title,author,pages,price) VALUES (?,?,?,?)";
                        Connection conn = DB.getConnection();
                        PreparedStatement pstmt = conn.prepareStatement(sql);
                 
                        pstmt.setString(1, title);
                        pstmt.setString(2, author);
                        pstmt.setInt(3, pages);
                        pstmt.setInt(4,price);
                        pstmt.executeUpdate();
                      response.sendRedirect("FrontPageJSP.jsp");
                   break;
                   
             case "seeBookList":
              
                break;
                
                
                case "test":
                    out.println("test");
                break;
                default: out.println("no orgin");
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
    try {
        processRequest(request, response);
    } catch (SQLException ex) {
        Logger.getLogger(NewServlet.class.getName()).log(Level.SEVERE, null, ex);
    }
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
    try {
        processRequest(request, response);
    } catch (SQLException ex) {
        Logger.getLogger(NewServlet.class.getName()).log(Level.SEVERE, null, ex);
    }
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
