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

public class GravarContatoPostAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        String nome = request.getParameter("textNome");
        String email = request.getParameter("textEmail");
        Integer empresaID = Integer.parseInt(request.getParameter("selectEmpresa"));
        if (nome.equals("") || email.equals("")) {
            response.sendRedirect("index.jsp");
        } else {
            try {
                Empresa empresa = EmpresaDAO.getINSTANCE().getEmpresaByID(empresaID);
                Contato contato = new Contato(nome, email,empresa);
                ContatoDAO.getINSTANCE().save(contato);
                response.sendRedirect("contatoSucesso.jsp");
            } catch (SQLException ex) {
                response.sendRedirect("contatoErro.jsp");
            }
        }
    }

}
