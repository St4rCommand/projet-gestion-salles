package org.univ.salles.vue.salle;

import org.univ.salles.controlleur.ControleurSalle;
import org.univ.salles.modele.entite.Batiment;
import org.univ.salles.modele.entite.TypeSalle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FenetreCreationSalle extends JFrame {

    private JPanel container = new JPanel();
    private JFrame fenetre = this;

    private JButton boutonValiderBatiment = new JButton("Suivant");
    private JButton boutonValiderType = new JButton("Suivant");
    private JButton boutonValiderSalle = new JButton("Terminé");

    private JPanel listeBatimentsPanel = new JPanel();
    private JComboBox listeBatiments = new JComboBox();
    private JLabel listeBatimentsLabel = new JLabel("Bâtiment");

    private JPanel listeTypesPanel = new JPanel();
    private JComboBox listeTypes = new JComboBox();
    private JLabel listeTypesLabel = new JLabel("Type");

    private JPanel noSallePanel = new JPanel();
    private JTextField noSalle = new JTextField();
    private JLabel noSalleLabel = new JLabel("Numéro");

    private JPanel noEtagePanel = new JPanel();
    private JTextField noEtage = new JTextField();
    private JLabel noEtageLabel = new JLabel("Etage");

    private JPanel superficiePanel = new JPanel();
    private JTextField superficie = new JTextField();
    private JLabel superficieLabel = new JLabel("Superficie");

    private ControleurSalle controleur;

    public FenetreCreationSalle(ControleurSalle controleur) {
        this.controleur = controleur;

        this.setTitle("Ajouter une salle");
        this.setSize(400, 200);
        this.setLocationRelativeTo(null);

        listeBatiments = new JComboBox(this.controleur.getBatimentList().toArray());
        listeBatiments.setPreferredSize(new Dimension(100, 20));
        listeBatimentsPanel.add(listeBatimentsLabel);
        listeBatimentsPanel.add(listeBatiments);

        container.add(listeBatimentsPanel);
        container.add(boutonValiderBatiment);

        boutonValiderBatiment.addActionListener(new BoutonValiderBatimentListener());
        this.setContentPane(container);


        this.setVisible(true);
    }

    private class BoutonValiderBatimentListener implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {

            listeTypes = new JComboBox(controleur.getTypesSalleList().toArray());
            listeTypes.setPreferredSize(new Dimension(100, 20));
            listeTypesPanel.add(listeTypesLabel);
            listeTypesPanel.add(listeTypes);

            container.removeAll();
            container.repaint();
            container.add(listeTypesPanel);
            container.add(boutonValiderType);

            boutonValiderType.addActionListener(new BoutonValiderTypeListener());

            fenetre.setContentPane(container);
            fenetre.setVisible(true);
        }
    }

    private class BoutonValiderTypeListener implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {

            noSalle.setPreferredSize(new Dimension(100, 20));
            noSallePanel.add(noSalleLabel);
            noSallePanel.add(noSalle);

            noEtage.setPreferredSize(new Dimension(100, 20));
            noEtagePanel.add(noEtageLabel);
            noEtagePanel.add(noEtage);

            superficie.setPreferredSize(new Dimension(100, 20));
            superficiePanel.add(superficieLabel);
            superficiePanel.add(superficie);

            container.removeAll();
            container.repaint();
            container.add(noSallePanel);
            container.add(noEtagePanel);
            container.add(superficiePanel);
            container.add(boutonValiderSalle);

            boutonValiderSalle.addActionListener(new BoutonValiderSalleListener());

            fenetre.setContentPane(container);
            fenetre.setVisible(true);
        }
    }

    private class BoutonValiderSalleListener implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {

            Batiment batiment = (Batiment) listeBatiments.getSelectedItem();
            TypeSalle type = (TypeSalle) listeTypes.getSelectedItem();
            Integer numero = Integer.valueOf(noSalle.getText());
            Integer etage = Integer.valueOf(noEtage.getText());
            Integer sup = Integer.valueOf(superficie.getText());

            controleur.addSalle(batiment, type, numero, etage, sup);
            fenetre.dispose();
        }
    }
}
