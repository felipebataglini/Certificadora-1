/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Produto;


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
public class DAOProduto {
    ResultSet rs;
    private Connection link;
    ArrayList<Produto> lista = new ArrayList();

    public DAOProduto() {
        this.link = new ConnectionFactory().getConnection();
    }

    public void Create(Produto p) {
        String sql = "INSERT INTO produto (pro_id, pro_nome, pro_marca, pro_tipo, pro_quantidade) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement stmt = link.prepareStatement(sql);
            stmt.setInt(1, p.getIdproduto());
            stmt.setString(2, p.getNome());
            stmt.setString(3, p.getMarca());
            stmt.setString(4, p.getTipo());
            stmt.setInt(5, p.getQuantidade());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void Remove(int pro_id) {
        String sql = "DELETE FROM produto WHERE pro_id = ?";
        try {
            PreparedStatement stmt = link.prepareStatement(sql);
            stmt.setInt(1, pro_id);
            stmt.execute();
            stmt.close();            
            JOptionPane.showMessageDialog(null, "Produto removido com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void Update(Produto p) {
        String sql = "UPDATE produto set pro_nome = ?, pro_marca = ?, pro_tipo=  ?, pro_quantidade = ? where pro_id = ?";
        try {
            PreparedStatement stmt = link.prepareStatement(sql);
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getMarca());
            stmt.setString(3, p.getTipo());
            stmt.setInt(4, p.getQuantidade());
            stmt.setInt(5, p.getIdproduto());
            stmt.execute();
            stmt.close();            
            JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ArrayList<Produto> Display() {
        String sql = "select * from produto";
        try {
            PreparedStatement stmt = link.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Produto objproduto = new Produto();
                objproduto.setIdproduto(rs.getInt("pro_id"));
                objproduto.setNome(rs.getString("pro_nome"));
                objproduto.setMarca(rs.getString("pro_marca"));
                objproduto.setTipo(rs.getString("pro_tipo"));
                objproduto.setQuantidade(rs.getInt("pro_quantidade"));
                lista.add(objproduto);
            }
            JOptionPane.showMessageDialog(null, "Produtos recuperados com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Erro!", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }
}
