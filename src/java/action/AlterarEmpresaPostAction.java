/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Empresa;
import persistence.EmpresaDAO;

/**
 *
 * @author Pedro
 */
public class AlterarEmpresaPostAction implements Action{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("id");
        int idEmpresa = Integer.parseInt(id);
        String nome = request.getParameter("nome");
        if (id == null|| nome.equals("")) {
            response.sendRedirect("index.jsp");
        } else {
            try {
                Empresa empresa = new Empresa(idEmpresa,nome);
                EmpresaDAO.getINSTANCE().update(empresa);
                response.sendRedirect("empresaSucesso.jsp");
            } catch (SQLException ex) {
                ex.getMessage();
            }
        }
    }
}
