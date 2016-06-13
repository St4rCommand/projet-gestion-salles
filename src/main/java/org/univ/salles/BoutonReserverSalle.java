package org.univ.salles;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by romain on 13/06/16.
 */
public class BoutonReserverSalle extends JButton {

    private String name;

    public BoutonReserverSalle(String str) {
        super(str);
        this.name = str;
    }
}
