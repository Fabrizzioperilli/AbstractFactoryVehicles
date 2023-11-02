package org.ull.es.dap;

import org.ull.es.dap.gui.MainWindow;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainWindow::new);
    }
}