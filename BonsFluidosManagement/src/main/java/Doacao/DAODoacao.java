/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Doacao;

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
public class DAODoacao {
    ResultSet rs;
    private Connection link;
    ArrayList<Doacao> lista = new ArrayList();
    
    public DAODoacao(){
        this.link = new ConnectionFactory().getConnection();
    }
     
    public void Create(Doacao d){
        String sql = "INSERT INTO doacao(doa_id, doa_data, esc_id, vol_id, pro-id) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement stmt = link.prepareStatement(sql);
            stmt.setInt(1, d.getIddoacao());
            stmt.setString(2,d.getData());
            stmt.setInt(3,d.getIdescola());
            stmt.setInt(4, d.getIdvoluntario());
            stmt.setInt(5, d.getIdproduto());
            stmt.execute();
            stmt.close();            
            JOptionPane.showMessageDialog(null, "Doação cadastrada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void Remove(int idDoa) {
        String sql = "DELETE FROM doacao WHERE doa_id= ?";
        try {
            PreparedStatement stmt = link.prepareStatement(sql);
            stmt.setInt(1, idDoa);
            stmt.execute();
            stmt.close();            
            JOptionPane.showMessageDialog(null, "Doação removida com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }
   
    public ArrayList<Doacao> Display() {
        String sql = "select * from doacao";
        try {
            PreparedStatement stmt = link.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Doacao objdoacao = new Doacao();
                objdoacao.setIddoacao(rs.getInt("doa_id"));
                objdoacao.setData(rs.getString("doa_data"));
                objdoacao.setIdescola(rs.getInt("esc_id"));
                objdoacao.setIdvoluntario(rs.getInt("vol_id"));
                objdoacao.setIdproduto(rs.getInt("pro_id"));
                lista.add(objdoacao);
            }
            JOptionPane.showMessageDialog(null, "Doações recuperadas com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Erro!", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }
}
