package com.clara;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class SnakeInfoGUI extends JFrame implements WindowListener {

    private JPanel rootPanel;
    private JTable snakeTable;
    private JButton quitButton;

    protected SnakeInfoGUI(SnakeModel sdm) {

        // You can write GUI code without IntelliJ designer.
        // This code would be very similar had the GUI designer been used.
        // Just create the components needed and add to a JPanel,
        // then add the JPanel to this object (a subclass of JFrame)

        rootPanel = new JPanel();
        snakeTable = new JTable();
        quitButton = new JButton("Quit");

        rootPanel.add(snakeTable);
        rootPanel.add(quitButton);

        setContentPane(rootPanel);

        pack();
        addWindowListener(this);
        setVisible(true);

        setSize(new Dimension(300, 150));

        //Set the tables' data model
        snakeTable.setModel(sdm);

        //Grid color default is white, change it so we can see it
        snakeTable.setGridColor(Color.BLACK);

        //Also make the first column wider
        snakeTable.getColumnModel().getColumn(0).setPreferredWidth(200);

        //Quit application when user closes window, otherwise app keeps running
        //Sometimes this is what you want, sometimes it isn't.
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Close button code.
        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Call Main's shutdown method - one class is the entry and exit point of the program
                Main.shutdown();
            }
        });

    }

    //Method provided by WindowListener interface
    //Called when user clicks the Window's close button. Would be a good idea to shut down app cleanly.
    public void windowClosing(WindowEvent e) {
        System.out.println("Window closing");
        Main.shutdown();
    }

    //A WindowListener is required to provide these methods
    //We can choose what they do - in this case, nothing
    public void windowClosed(WindowEvent e) {}
    public void windowOpened(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowActivated(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}

}
