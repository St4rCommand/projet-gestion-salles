package org.univ.reservations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by romain on 13/06/16.
 */
public class FenetreReservation extends JFrame {

    private JPanel container = new JPanel();

    private JPanel listeSallesPanel = new JPanel();
    private JComboBox listeSalles = new JComboBox();
    private JLabel listeSallesLabel = new JLabel("Choisir la salle");

    private JPanel noSallePanel = new JPanel();
    private JTextField noSalle = new JTextField();
    private JLabel noSalleLabel = new JLabel("Saisir le numéro de la salle");

    public FenetreReservation() {
        this.setTitle("Réserver une salle");
        this.setSize(400, 200);
        this.setLocationRelativeTo(null);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        listeSalles.setPreferredSize(new Dimension(100, 20));
        listeSallesPanel.add(listeSallesLabel);
        listeSallesPanel.add(listeSalles);

        noSalle.setPreferredSize(new Dimension(100, 20));
        noSallePanel.add(noSalleLabel);
        noSallePanel.add(noSalle);

        container.add(listeSallesPanel);
        container.add(noSallePanel);

        this.setContentPane(container);

        this.setVisible(true);
    }

    private class BoutonReserverSalleListener implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {
            System.out.println("click");
        }
    }
}
