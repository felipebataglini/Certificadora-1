/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Produto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Leonardo
 */
public class GerenciadorProduto implements ActionListener{
    private GUIProduto guiproduto;
    private DAOProduto daoproduto;
    private Produto p;
    
    public GerenciadorProduto(){
        guiproduto = new GUIProduto();
        guiproduto.addListener(this);
        daoproduto = new DAOProduto();
        p = new Produto();
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton botaopressionado = (JButton)e.getSource();
        String opc = botaopressionado.getName();
        
        switch(opc){
            case "cadastrar":
                p = guiproduto.getProduto();
                daoproduto.Create(p);
                guiproduto.limpar();
                break;                
            case "deletar":
                int idPro = guiproduto.getIdproduto();
                daoproduto.Remove(idPro);
                guiproduto.limpar();
                break;
            case "alterar":
                p = guiproduto.getProduto();
                daoproduto.Update(p);
                guiproduto.limpar();
                break;
            case "mostrar":
                guiproduto.consultar();
                break;
        }
    }    
}
