package org.univ.salles.vue.reservation;

import org.univ.salles.controlleur.ControleurReservation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FenetreReservation extends JFrame {

    private JPanel container = new JPanel();

    private JPanel listeSallesPanel = new JPanel();
    private JComboBox listeSalles = new JComboBox();
    private JLabel listeSallesLabel = new JLabel("Choisir la salle");

    private JPanel noSallePanel = new JPanel();
    private JTextField noSalle = new JTextField();
    private JLabel noSalleLabel = new JLabel("Saisir le numéro de la salle");

    private ControleurReservation controleur;

    public FenetreReservation(ControleurReservation controleur) {

        this.controleur = controleur;

        this.setTitle("Réserver une salle");
        this.setSize(400, 200);
        this.setLocationRelativeTo(null);

        listeSalles = new JComboBox(this.controleur.getSalleList().toArray());
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
