/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Escola;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Leonardo
 */
public class GerenciadorEscola implements ActionListener {
    private GUIEscola guiescola;
    private DAOEscola daoescola;
    private Escola e;

    public GerenciadorEscola() {
        guiescola = new GUIEscola();
        guiescola.addListener(this);
        daoescola = new DAOEscola();
        e = new Escola();
    }

    @Override
    public void actionPerformed(ActionEvent a) {
        JButton botaopressionado = (JButton) a.getSource();
        String opc = botaopressionado.getName();

        switch (opc) {
            case "cadastrar":
                e = guiescola.getEscola();
                daoescola.Create(e);
                guiescola.limpar();
                break;
            case "deletar":
                int idEsc = guiescola.getID();
                daoescola.Remove(idEsc);
                guiescola.limpar();
                break;
            case "alterar":
                e = guiescola.getEscola();
                daoescola.Update(e);
                guiescola.limpar();
                break;
            case "mostrar":
                guiescola.consultar();
                break;
        }
    }

}
