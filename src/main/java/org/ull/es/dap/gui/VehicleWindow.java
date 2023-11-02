package org.ull.es.dap.gui;

import org.ull.es.dap.connections.CSVReader;
import org.ull.es.dap.connections.Parser;
import org.ull.es.dap.connections.ParserBrands;
import org.ull.es.dap.factory.CabrioFactory;
import org.ull.es.dap.factory.SUVFactory;
import org.ull.es.dap.factory.SedanFactory;
import org.ull.es.dap.factory.VehicleFactory;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class VehicleWindow extends JFrame {
    public static final String SUV = "SUV";
    public static final String SEDAN = "Sedan";
    public static final String CABRIO = "Cabrio";
    private JLabel titleLabel, logoLabel;
    private String brand;


    public VehicleWindow(String typeVehicle, String brand) {
        super(brand + ". " + typeVehicle);
        this.brand = brand;
        getContentPane().setBackground(Color.WHITE);
        initializeUI();
        addTitleLabel(brand, typeVehicle);
        Parser dataBrands = new ParserBrands(new CSVReader("https://docs.google.com/spreadsheets/d/e/2PACX-1vQx_cgEFGrE7Y92T3bQNfDbVq0z2v_vY0fFmXDW9XSvNb46fKwuRthwcENnTDUBB9xy-ssNlC0wW_kT/pub?output=csv"));

        addLogoLabel(dataBrands, 140, 140);

        VehicleFactory factory = switch (typeVehicle) {
            case SUV -> new SUVFactory();
            case SEDAN -> new SedanFactory();
            case CABRIO -> new CabrioFactory();
            default -> null;
        };

        DisplayPanel displayPanel = new DisplayPanel(brand, factory);
        add(displayPanel);
    }

    private void initializeUI() {
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(930, 700);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addTitleLabel(String brand, String typeVehicle) {
        titleLabel = new JLabel(brand + ".  " + typeVehicle);
        titleLabel.setBounds(325, 60, 500, 60);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 42));
        add(titleLabel);
    }

    private void addLogoLabel(Parser dataBrands, int newWidth, int newHeight) {
        String imageUrl = findBrandImageUrl(dataBrands, brand);

        try {
            ImageIcon originalIcon = new ImageIcon(new URL(imageUrl));
            Image originalImage = originalIcon.getImage();
            Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);

            logoLabel = new JLabel(scaledIcon);
            logoLabel.setBounds(120, 30, newWidth, newHeight);
            add(logoLabel);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private String findBrandImageUrl(Parser dataBrands, String brand) {
        for (List<Object> rowData : dataBrands.getData())
            if (rowData.get(0).equals(brand))
                return (String) rowData.get(1);
        return "";
    }
}
