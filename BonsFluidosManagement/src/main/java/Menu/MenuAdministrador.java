/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menu;

import Administrador.GerenciadorAdministrador;
import Escola.GerenciadorEscola;
import Voluntario.GerenciadorVoluntario;
import Doacao.GerenciadorDoacao;
import Produto.GerenciadorProduto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Gabriel
 */
public class MenuAdministrador implements ActionListener{
    private GUIMenuAdministrador guimenuadministrador;
    
    public MenuAdministrador(){
        guimenuadministrador = new GUIMenuAdministrador();
        guimenuadministrador.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton botaopressionado = (JButton)e.getSource();
        String opc = botaopressionado.getName();
        
        switch(opc){
            case "administrador":
                new GerenciadorAdministrador();
                break;
                
            case "escola":
                new GerenciadorEscola();
                break;
                
            case "voluntario":
                new GerenciadorVoluntario();
                break;
                
            case "doacao":
                new GerenciadorDoacao();
                break;
                
            case "produto":
                new GerenciadorProduto();
                break;
        }
    }
}
