//Pacote
package Escola;

//Importações
import Factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Matheus
 */
public class DAOEscola {
    ResultSet rs;
    private Connection link;
    ArrayList<Escola> lista = new ArrayList();

    public DAOEscola() {
        this.link = new ConnectionFactory().getConnection();
    }

    public void Create(Escola c) {
        String sql = "INSERT INTO escola(esc_id, esc_nome, esc_endereco, esc_responsavel, esc_email, esc_telefone) VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = link.prepareStatement(sql);
            stmt.setInt(1, c.getIDEscola());
            stmt.setString(2, c.getNome());
            stmt.setString(3, c.getEndereco());
            stmt.setString(4, c.getResponsavel());
            stmt.setString(5, c.getEmail());
            stmt.setLong(6, c.getTelefone());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Escola cadastrada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void Remove(int idEscola) {
        String sql = "DELETE FROM escola WHERE esc_id = ?";
        try {
            PreparedStatement stmt = link.prepareStatement(sql);
            stmt.setInt(1, idEscola);
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Escola excluída com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void Update(Escola c) {
        String sql = "UPDATE escola set esc_nome = ?,  esc_endereco =  ?, esc_email = ? where esc_id = ?";
        try {
            PreparedStatement stmt = link.prepareStatement(sql);
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getEndereco());
            stmt.setString(3, c.getEmail());
            stmt.setInt(4, c.getIDEscola());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Escola atualizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ArrayList<Escola> Display() {
        String sql = "select * from escola";
        try {
            PreparedStatement stmt = link.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Escola objescola = new Escola();
                objescola.setIDEscola(rs.getInt("esc_id"));
                objescola.setNome(rs.getString("esc_nome"));
                objescola.setEndereco(rs.getString("esc_endereco"));
                objescola.setResponsavel(rs.getString("esc_responsavel"));
                objescola.setEmail(rs.getString("esc_email"));
                objescola.setTelefone(rs.getLong("esc_telefone"));
                lista.add(objescola);
            }
            JOptionPane.showMessageDialog(null, "Escolas recuperadas com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Erro!", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }

}
