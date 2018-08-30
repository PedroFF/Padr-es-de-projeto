
package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Contato;
import model.Empresa;
import persistence.ContatoDAO;
import persistence.EmpresaDAO;


public class ApagarContatoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            List<Empresa> empresas = new ArrayList(EmpresaDAO.getINSTANCE().getEmpresas());
            request.setAttribute("empresas", empresas);
            request.getRequestDispatcher("apagarContato.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ApagarContatoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
