package com.arcia;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class App extends JFrame {
    private static final long serialVersionUID = -5820739655618326101L;

    public App() {
        initUI();
    }

    public void initUI() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        add(new Animation());
        pack();
        setTitle("Fire");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            App app = new App();
            app.setVisible(true);
        });
    }
}
