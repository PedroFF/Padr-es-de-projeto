package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Contato;
import model.Empresa;
import persistence.ContatoDAO;
import persistence.EmpresaDAO;


public class LerEmpresaPostAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        String nome = request.getParameter("textNome");
        if (nome.equals("")) {
            response.sendRedirect("index.jsp");
        } else {
            try {
                Empresa empresa = EmpresaDAO.getINSTANCE().read(nome);
                if (empresa != null) {
                    request.setAttribute("empresa", empresa);
                    request.getRequestDispatcher("lerEmpresa.jsp").forward(request, response);
                } else {
                    response.sendRedirect("empresaErro.jsp");
                }
            } catch (SQLException ex) {
                Logger.getLogger(LerEmpresaPostAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
