package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Contato;
import model.Empresa;

public class ContatoDAO {

    private static final ContatoDAO INSTANCE = new ContatoDAO();

    public static ContatoDAO getINSTANCE() {
        return INSTANCE;
    }

    public void save(Contato contato) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            String sql = "insert into contato(nome, email,fk_empresa) values ('" + contato.getNome() + "', '" + contato.getEmail() + "'," + contato.getEmpresa().getId() + ")";
            st.execute(sql);
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public void update(Contato contato) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("UPDATE contato SET email ='" + contato.getEmail() + "' WHERE nome ='" + contato.getNome() + "'");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public void delete(Contato contato) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("DELETE FROM contato WHERE nome ='" + contato.getNome() + "'");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public Contato read(String nome) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            String sql = "SELECT * FROM CONTATO WHERE NOME ='" + nome + "'";
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                Empresa empresa = EmpresaDAO.getINSTANCE().getEmpresaByID(rs.getInt("fk_empresa"));
                return new Contato(rs.getString("nome"), rs.getString("email"), empresa);
            }

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return null;
    }

    private void closeResources(Connection conn, Statement st) {
        try {
            if (st != null) {
                st.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            ex.getErrorCode();
        }
    }

    public List<Contato> getAllContatos() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        List<Contato> contatos = new ArrayList<>();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            String sql = "SELECT * FROM CONTATO";
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                contatos.add(this.read(rs.getString("nome")));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return contatos;
    }
}
