package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Contato;
import persistence.ContatoDAO;

public class LerContatoPostAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        String nome = request.getParameter("textNome");
        if (nome.equals("")) {
            response.sendRedirect("index.jsp");
        } else {
            try {
                Contato contato = ContatoDAO.getINSTANCE().read(nome);
                if (contato != null) {
                    request.setAttribute("contato", contato);
                    request.getRequestDispatcher("lerContato.jsp").forward(request, response);
                }else{
                    response.sendRedirect("contatoErro.jsp");
                }
            } catch (SQLException ex) {
                ex.getMessage();
            }
        }
    }

}
