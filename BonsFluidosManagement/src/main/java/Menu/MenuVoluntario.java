/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menu;

import Escola.GerenciadorEscola;
import Doacao.GerenciadorDoacao;
import Produto.GerenciadorProduto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Gabriel
 */
public class MenuVoluntario implements ActionListener{
    private GUIMenuVoluntario guimenuvoluntario;
    
    public MenuVoluntario(){
        guimenuvoluntario = new GUIMenuVoluntario();
        guimenuvoluntario.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton botaopressionado = (JButton)e.getSource();
        String opc = botaopressionado.getName();
        
        switch(opc){
            case "escola":
                new GerenciadorEscola();
                break;
                
            case "produto":
                new GerenciadorProduto();
                break;
                
            case "doacao":
                new GerenciadorDoacao();
                break;
        }
    }
}
