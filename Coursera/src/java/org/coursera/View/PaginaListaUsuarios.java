/*
Trabalho de Programação Web
Alunos: Athos e Ricardo
Tema: coursera.org

Esta servlet é a página de lista de usuarios. É verificado se o usuario está logado
e tem permissões administrativas.
*/

package org.coursera.View;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.coursera.Model.HTML;

@WebServlet(name = "Usuarios", urlPatterns = {"/Usuarios"})
public class PaginaListaUsuarios extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        if (request.getSession().getAttribute("logado") == null) {
            pw.println(HTML.aviso("Você não está logado! Entre para fazer esssa operação.", request));
        } else if (request.getSession().getAttribute("tipo_usr").equals("normal")) {
            pw.println(HTML.aviso("Acesso não autorizado!", request));
        } else if (request.getSession().getAttribute("tipo_usr").equals("administrativo")) {
            pw.println(HTML.head("Lista de Usuarios - Coursera"));
            pw.println(HTML.bodyInicio(request));
            pw.println(HTML.bodyListaAlunos());
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
