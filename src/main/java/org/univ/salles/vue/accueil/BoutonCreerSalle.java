package org.univ.salles.vue.accueil;

import javax.swing.*;

public class BoutonCreerSalle extends JButton {

    private String name;

    public BoutonCreerSalle(String str) {
        super(str);
        this.name = str;
    }
}
