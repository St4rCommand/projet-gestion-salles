package org.univ.salles.vue.accueil;

import javax.swing.*;

public class BoutonReserverSalle extends JButton {

    private String name;

    public BoutonReserverSalle(String str) {
        super(str);
        this.name = str;
    }
}
