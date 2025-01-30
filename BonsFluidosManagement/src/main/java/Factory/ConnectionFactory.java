//Pacote
package Factory;

//Importações
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Felipe
 */
public class ConnectionFactory {
    private String url = "jdbc:mysql://febataglini.duckdns.org:3306/bfm";
    private String user = "user";
    private String password = "password";
    
    public Connection getConnection() {
        try {
            return DriverManager.getConnection(url,user,password);
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Erro!", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(e);
        }
    }
}
