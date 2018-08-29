package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Contato;
import model.Empresa;
import persistence.ContatoDAO;
import persistence.EmpresaDAO;

public class GravarEmpresaPostAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        String nome = request.getParameter("textNome");
        if (nome.equals("")) {
            response.sendRedirect("index.jsp");
        } else {
            try {
                Empresa empresa = new Empresa(nome);
                EmpresaDAO.getINSTANCE().save(empresa);
                response.sendRedirect("empresaSucesso.jsp");
            } catch (SQLException ex) {
                response.sendRedirect("empresaErro.jsp");
            }
        }
    }

}
