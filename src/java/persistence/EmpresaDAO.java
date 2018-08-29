package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Empresa;

public class EmpresaDAO {

    private static final EmpresaDAO INSTANCE = new EmpresaDAO();

    public static EmpresaDAO getINSTANCE() {
        return INSTANCE;
    }

    public void save(Empresa empresa) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into empresa(nomeEmpresa) values ('" + empresa.getNome() + "')");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
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

    public Empresa getEmpresaByID(Integer id) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            String sql = "SELECT * FROM EMPRESA WHERE ID =" + id;
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                return new Empresa(rs.getInt("id"), rs.getString("nomeEmpresa"));
            }

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return null;
    }

    public List<Empresa> getEmpresas() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        List<Empresa> empresas = new ArrayList<>();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            String sql = "SELECT * FROM EMPRESA";
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                empresas.add(new Empresa(rs.getInt("id"), rs.getString("nomeEmpresa")));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return empresas;
    }

}
