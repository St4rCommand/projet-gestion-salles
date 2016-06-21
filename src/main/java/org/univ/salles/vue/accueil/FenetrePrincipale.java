package org.univ.salles.vue.accueil;

import org.univ.salles.controlleur.ControleurMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FenetrePrincipale extends JFrame {

    private JButton boutonReserverSalle = new BoutonReserverSalle("Réserver une salle");
    private JButton boutonCreerSalle = new BoutonCreerSalle("Créer une nouvelle salle");
    private ControleurMenu controleur = null;

    public FenetrePrincipale(ControleurMenu controleur) {
        this.setTitle("Gestion Salles");
        this.setSize(400, 200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridLayout gl = new GridLayout(3,2);
        gl.setHgap(5);

        this.setLayout(gl);
        this.getContentPane().add(boutonReserverSalle);
        this.getContentPane().add(boutonCreerSalle);
        boutonReserverSalle.addActionListener(new BoutonReserverSalleListener());
        boutonCreerSalle.addActionListener(new BoutonCreerSalleListener());

        this.controleur = controleur;

        this.setVisible(true);
    }

    private class BoutonReserverSalleListener implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {
            controleur.reserverSalle();
        }
    }

    private class BoutonCreerSalleListener implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {
            controleur.creerSalle();
        }
    }
}
