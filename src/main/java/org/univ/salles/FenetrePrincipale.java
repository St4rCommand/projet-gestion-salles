package org.univ.salles;

import org.univ.reservations.FenetreReservation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by romain on 13/06/16.
 */
public class FenetrePrincipale extends JFrame {

    private JButton boutonReserverSalle = new BoutonReserverSalle("Réserver une salle");

    public FenetrePrincipale() {
        this.setTitle("Gestion Salles");
        this.setSize(400, 200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridLayout gl = new GridLayout(3,2);
        gl.setHgap(5);

        this.setLayout(gl);
        this.getContentPane().add(boutonReserverSalle);
        boutonReserverSalle.addActionListener(new BoutonReserverSalleListener());

        this.setVisible(true);
    }

    private class BoutonReserverSalleListener implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {
            new FenetreReservation();
        }
    }
}
