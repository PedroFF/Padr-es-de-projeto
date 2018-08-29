
package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Contato;
import persistence.ContatoDAO;


public class AlterarContatoPostAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        String nome = request.getParameter("textNome");
        String email = request.getParameter("textEmail");
        if (nome.equals("") || email.equals("")) {
            response.sendRedirect("index.jsp");
        } else {
            try {
                Contato contato = new Contato(nome, email);
                ContatoDAO.getINSTANCE().update(contato);
                response.sendRedirect("contatoSucesso.jsp");
            } catch (SQLException ex) {
                ex.getMessage();
            }
        }
    }
    
}
