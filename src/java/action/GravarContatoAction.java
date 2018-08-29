package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.EmpresaDAO;

public class GravarContatoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            request.setAttribute("empresas", EmpresaDAO.getINSTANCE().getEmpresas());
            request.getRequestDispatcher("inserirContato.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(GravarContatoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
