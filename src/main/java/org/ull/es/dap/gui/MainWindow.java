package org.ull.es.dap.gui;

import javax.swing.*;

import org.ull.es.dap.connections.CSVReader;
import org.ull.es.dap.connections.Parser;
import org.ull.es.dap.connections.ParserVehicles;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainWindow extends JFrame {
    private JComboBox<String> vehicleTypeComboBox;
    private JLabel titleLabel;
    private JButton acceptButton;

    public MainWindow() {
        super("Bienvenido al programa");
        initializeUI();
        addTitleLabel();

        Parser dataTypes = new ParserVehicles(new CSVReader("https://docs.google.com/spreadsheets/d/e/2PACX-1vQK9itp5qR25HyujgA2vp53Z3-oYxauGgpk9Ftn6ZL3fstkhs4-dtJliHBXML4s7_jM0MNqTDzTPw3L/pub?output=csv"));
        configureVehicleTypeComboBox(dataTypes);

        configureAcceptButton();
        setVisible(true);
    }

    private void initializeUI() {
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(930, 300);
        setLocationRelativeTo(null);
    }

    private void addTitleLabel() {
        titleLabel = new JLabel("Seleccione el tipo de vehículo que desee:");
        titleLabel.setBounds(115, 60, 700, 60);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 34));
        add(titleLabel);
    }

    private void configureVehicleTypeComboBox(Parser dataTypes) {
        // Obtiene los tipos de vehículos desde dataTypes, se usa Set para evitar repeticiones
        List<List<Object>> data = dataTypes.getData();
        Set<String> vehicleTypes = new HashSet<>();

        for (int i = 0; i < data.size(); i++) {
            String vehicleType = (String) data.get(i).get(1);
            vehicleTypes.add(vehicleType);
        }

        // Crea el combo box con los tipos de vehículos sin repeticiones
        String[] uniqueVehicleTypes = vehicleTypes.toArray(new String[0]);
        Arrays.sort(uniqueVehicleTypes);

        String[] comboBoxItems = new String[uniqueVehicleTypes.length + 1];
        comboBoxItems[0] = "Despliegue para ver las opciones...";

        // Copia los valores sin repeticiones después del primer elemento
        System.arraycopy(uniqueVehicleTypes, 0, comboBoxItems, 1, uniqueVehicleTypes.length);

        vehicleTypeComboBox = new JComboBox<>(comboBoxItems);
        vehicleTypeComboBox.setBounds(130, 150, 300, 30);
        add(vehicleTypeComboBox);
    }

    private void configureAcceptButton() {
        // Crea el botón de aceptar
        acceptButton = new JButton("Aceptar");
        acceptButton.setBounds(550, 150, 100, 30);
        add(acceptButton);

        // Agrega un ActionListener al botón
        acceptButton.addActionListener (new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (vehicleTypeComboBox.getSelectedItem() != null && vehicleTypeComboBox.getSelectedItem().toString() != "") {
                    String selectedVehicleType = (String) vehicleTypeComboBox.getSelectedItem();
                    
                    if (e.getSource() == acceptButton) {
                        if (selectedVehicleType.contains("Despliegue para ver las opciones...")) {
                            JOptionPane.showMessageDialog(null, "Primero debe seleccionar una de las opciones para poder continuar.");
                        }
                    } else {
                        SwingUtilities.invokeLater(() -> new BrandWindow(selectedVehicleType));
                    }
                } 
            }
        });
    }
}
