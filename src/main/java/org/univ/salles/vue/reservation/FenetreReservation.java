package org.univ.salles.vue.reservation;

import org.univ.salles.controlleur.ControleurReservation;
import org.univ.salles.modele.entite.Materiel;
import org.univ.salles.modele.entite.TypeSalle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class FenetreReservation extends JFrame {

    private static final int WIDTH = 200;

    private JPanel container = new JPanel();
    private JFrame fenetre = this;

    private JButton boutonValiderDemandeur = new JButton("Suivant");
    private JButton boutonValiderDate = new JButton("Suivant");
    private JButton boutonValiderType = new JButton("Rechercher");
    private JButton boutonValiderSalle = new JButton("Suivant");
    private JButton boutonValiderManifestation = new JButton("Suivant");
    private JButton boutonValiderMateriel = new JButton("Ajouter");
    private JButton boutonValiderReservation = new JButton("Réserver");

    private JPanel listeDemandeursPanel = new JPanel();
    private JComboBox listeDemandeurs = new JComboBox();
    private JLabel listeDemandeursLabel = new JLabel("Choisir le demandeur");


    private JPanel anneePanel = new JPanel();
    private JTextField annee = new JTextField();
    private JLabel anneeLabel = new JLabel("Année");


    private JPanel moisPanel = new JPanel();
    private JTextField mois = new JTextField();
    private JLabel moisLabel = new JLabel("Mois");


    private JPanel jourPanel = new JPanel();
    private JTextField jour = new JTextField();
    private JLabel jourLabel = new JLabel("Jour");


    private JPanel dureePanel = new JPanel();
    private JTextField duree = new JTextField();
    private JLabel dureeLabel = new JLabel("Durée");

    private JPanel listeTypesPanel = new JPanel();
    private JComboBox listeTypes = new JComboBox();
    private JLabel listeTypesLabel = new JLabel("Type");

    private JPanel listeSallesPanel = new JPanel();
    private JComboBox listeSalles = new JComboBox();
    private JLabel listeSallesLabel = new JLabel("Choisir la salle");

    private JPanel listeManifestationPanel = new JPanel();
    private JComboBox listeManifestation = new JComboBox();
    private JLabel listeManifestationLabel = new JLabel("Choisir la salle");

    private JPanel listeMaterielPanel = new JPanel();
    private JComboBox listeMateriel = new JComboBox();
    private JLabel listeMaterielLabel = new JLabel("Matériel");

    private ControleurReservation controleur;
    private java.util.List<Materiel> materiels = new ArrayList<Materiel>();

    public FenetreReservation(ControleurReservation controleur) {

        this.controleur = controleur;

        this.setTitle("Réserver une salle");
        this.setSize(400, 200);
        this.setLocationRelativeTo(null);

        listeDemandeurs = new JComboBox(controleur.getDemandeurList().toArray());
        listeDemandeurs.setPreferredSize(new Dimension(WIDTH, 20));
        listeDemandeursPanel.add(listeDemandeursLabel);
        listeDemandeursPanel.add(listeDemandeurs);

        container.add(listeDemandeursPanel);
        container.add(boutonValiderDemandeur);

        boutonValiderDemandeur.addActionListener(new BoutonValiderDemandeurListener());

        this.setContentPane(container);

        this.setVisible(true);
    }

    private class BoutonValiderDemandeurListener implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {
            annee.setPreferredSize(new Dimension(WIDTH, 20));
            anneePanel.add(anneeLabel);
            anneePanel.add(annee);

            mois.setPreferredSize(new Dimension(WIDTH, 20));
            moisPanel.add(moisLabel);
            moisPanel.add(mois);

            jour.setPreferredSize(new Dimension(WIDTH, 20));
            jourPanel.add(jourLabel);
            jourPanel.add(jour);

            duree.setPreferredSize(new Dimension(WIDTH, 20));
            dureePanel.add(dureeLabel);
            dureePanel.add(duree);

            container.removeAll();
            container.repaint();
            container.add(anneePanel);
            container.add(moisPanel);
            container.add(jourPanel);
            container.add(dureePanel);
            container.add(boutonValiderDate);

            boutonValiderDate.addActionListener(new BoutonValiderDateListener());

            fenetre.setContentPane(container);
            fenetre.setVisible(true);
        }
    }

    private class BoutonValiderDateListener implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {

            listeTypes = new JComboBox(controleur.getTypesSalleList().toArray());
            listeTypes.setPreferredSize(new Dimension(WIDTH, 20));
            listeTypesPanel.add(listeTypesLabel);
            listeTypesPanel.add(listeTypes);

            container.removeAll();
            container.repaint();
            container.add(listeTypes);
            container.add(boutonValiderType);

            boutonValiderType.addActionListener(new BoutonValiderTypeListener());

            fenetre.setContentPane(container);
            fenetre.setVisible(true);
        }
    }

    private class BoutonValiderTypeListener implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {

            Date date = new Date(Integer.valueOf(annee.getText()), Integer.valueOf(mois.getText()), Integer.valueOf(jour.getText()));
            TypeSalle type = (TypeSalle) listeTypes.getSelectedItem();

            listeSalles = new JComboBox(controleur.getSalleList(date, Integer.valueOf(duree.getText()), type).toArray());
            listeSalles.setPreferredSize(new Dimension(WIDTH, 20));
            listeSallesPanel.add(listeSallesLabel);
            listeSallesPanel.add(listeSalles);

            container.removeAll();
            container.repaint();
            container.add(listeSalles);
            container.add(boutonValiderSalle);

            boutonValiderSalle.addActionListener(new BoutonValiderSalleListener());

            fenetre.setContentPane(container);
            fenetre.setVisible(true);
        }
    }

    private class BoutonValiderSalleListener implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {

            listeManifestation = new JComboBox(controleur.getManifestationList().toArray());
            listeManifestation.setPreferredSize(new Dimension(WIDTH, 20));
            listeManifestationPanel.add(listeManifestationLabel);
            listeManifestationPanel.add(listeManifestation);

            container.removeAll();
            container.repaint();
            container.add(listeManifestation);
            container.add(boutonValiderManifestation);

            boutonValiderManifestation.addActionListener(new BoutonValiderManifestationListener());

            fenetre.setContentPane(container);
            fenetre.setVisible(true);
        }
    }

    private class BoutonValiderManifestationListener implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {
            listeMateriel = new JComboBox(controleur.getMaterielList().toArray());
            listeMateriel.setPreferredSize(new Dimension(WIDTH, 20));
            listeMaterielPanel.add(listeMaterielLabel);
            listeMaterielPanel.add(listeMateriel);

            container.removeAll();
            container.repaint();
            container.add(listeMateriel);
            container.add(boutonValiderMateriel);
            container.add(boutonValiderReservation);

            boutonValiderMateriel.addActionListener(new BoutonValiderMaterielListener());
            boutonValiderReservation.addActionListener(new BoutonReserverSalleListener());

            fenetre.setContentPane(container);
            fenetre.setVisible(true);
        }
    }

    private class BoutonValiderMaterielListener implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {
            materiels.add((Materiel) listeMateriel.getSelectedItem());

            listeMateriel = new JComboBox(controleur.getMaterielList().toArray());
            listeMateriel.setSelectedIndex(-1);
            listeMateriel.setPreferredSize(new Dimension(WIDTH, 20));
            listeMaterielPanel.add(listeMaterielLabel);
            listeMaterielPanel.add(listeMateriel);

            container.add(listeMateriel);
            container.add(boutonValiderMateriel);

            fenetre.setVisible(true);
        }
    }

    private class BoutonReserverSalleListener implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {

            System.out.println(materiels.toString());
            System.out.println("click");
        }
    }
}
