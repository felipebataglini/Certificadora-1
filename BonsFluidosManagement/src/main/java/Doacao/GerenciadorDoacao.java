/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Doacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Leonardo
 */
public class GerenciadorDoacao implements ActionListener {
    private GUIDoacao guidoacao;
    private DAODoacao daodoacao;
    private Doacao d;
  
    public GerenciadorDoacao(){
        guidoacao = new GUIDoacao();
        guidoacao.addListener(this);
        daodoacao = new DAODoacao();
        d = new Doacao();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton botaopressionado = (JButton)e.getSource();
        String opc = botaopressionado.getName();
          
        switch(opc){
            case "cadastrar":
                d = guidoacao.getDoacao();
                daodoacao.Create(d);
                guidoacao.limpar();
                break;                 
            case "deletar":
                int idDoa = guidoacao.getID();
                daodoacao.Remove(idDoa);
                guidoacao.limpar();
                break;
            case "mostrar":
                guidoacao.consultar();
                break;
        }
    }
}
