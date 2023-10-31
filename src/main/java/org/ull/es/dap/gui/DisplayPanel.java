package org.ull.es.dap.gui;

import org.ull.es.dap.brands.audi.VehicleAudi;
import org.ull.es.dap.brands.bmw.VehicleBMW;
import org.ull.es.dap.brands.mercedezbenz.VehicleMercedesBenz;
import org.ull.es.dap.connections.CSVReader;
import org.ull.es.dap.connections.Parser;
import org.ull.es.dap.connections.ParserVehicles;
import org.ull.es.dap.factory.CabrioFactory;
import org.ull.es.dap.factory.SUVFactory;
import org.ull.es.dap.factory.SedanFactory;
import org.ull.es.dap.factory.VehicleFactory;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class DisplayPanel extends JScrollPane {
    public static final String BMW = "BMW";
    public static final String AUDI = "Audi";
    public static final String MERCEDES_BENZ = "Mercedes Benz";
    private static final String SUV = "Suv";
    private static final String CABRIO = "Cabrio";
    private static final String SEDAN = "Sedan";
    private String brand;
    private Parser data;
    private VehicleFactory factory;

    public DisplayPanel(String brand, VehicleFactory factory) {
        this.brand = brand;
        this.factory = factory;
        this.data = new ParserVehicles(new CSVReader("https://docs.google.com/spreadsheets/d/e/2PACX-1vQK9itp5qR25HyujgA2vp53Z3-oYxauGgpk9Ftn6ZL3fstkhs4-dtJliHBXML4s7_jM0MNqTDzTPw3L/pub?output=csv"));

        setBounds(120, 200, 700, 400);
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        String opVehicle = "";
        if (factory instanceof SUVFactory)
            opVehicle = SUV;
        else if (factory instanceof SedanFactory)
            opVehicle = SEDAN;
        else if (factory instanceof CabrioFactory)
            opVehicle = CABRIO;

        for (int i = 0; i < data.getData().size(); i++) {
            if (data.getData().get(i).get(0).equals(brand) && data.getData().get(i).get(1).equals(opVehicle)) {
                String brandData = (String) data.getData().get(i).get(0);
                String typeVehicle = (String) data.getData().get(i).get(1);
                String model = (String) data.getData().get(i).get(2);
                int year = (int) data.getData().get(i).get(3);
                String fuel = (String) data.getData().get(i).get(4);
                double price = (double) data.getData().get(i).get(5);
                String urlImage = (String) data.getData().get(i).get(6);

                buildBrand(brandData, factory, mainPanel, typeVehicle, model, year, fuel, price, urlImage);
            }
        }

        mainPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        setAlignmentX(Component.LEFT_ALIGNMENT);

        setViewportView(mainPanel);
        setPreferredSize(new Dimension(700, 400));
        setBorder(null);
    }

    private void buildBrand(String brand, VehicleFactory factory, JPanel mainPanel, String typeVehicle, String model, int year, String fuel, double price, String urlImage) {
        if (brand.equals(BMW)) {
            VehicleBMW vehicleBMW = factory.createVehicleBMW(brand, typeVehicle, model, year, fuel, price, urlImage);
            mainPanel.add(createItem(vehicleBMW.description(), urlImage, 250, 150));
        } else if (brand.equals(AUDI)) {
            VehicleAudi vehicleAudi = factory.createVehicleAudi(brand, typeVehicle, model, year, fuel, price, urlImage);
            mainPanel.add(createItem(vehicleAudi.description(), urlImage, 250, 150));
        } else if (brand.equals(MERCEDES_BENZ)) {
            VehicleMercedesBenz vehicleMercedesBenz = factory.createVehicleMercedesBenz(brand, typeVehicle, model, year, fuel, price, urlImage);
            mainPanel.add(createItem(vehicleMercedesBenz.description(), urlImage, 250, 150));
        }
    }


    private JPanel createItem(String modelName, String imageUrl, int imageWidth, int imageHeight) {
        JPanel item = new JPanel();
        item.setBackground(Color.WHITE);
        item.setLayout(new BoxLayout(item, BoxLayout.X_AXIS));

        JLabel imageLabel = createImageLabel(imageUrl, imageWidth, imageHeight);
        JLabel descriptionLabel = createDescriptionLabel(modelName);

        item.add(imageLabel);
        item.add(descriptionLabel);
        item.setAlignmentX(Component.LEFT_ALIGNMENT);

        return item;
    }

    private JLabel createImageLabel(String imageUrl, int imageWidth, int imageHeight) {
        JLabel imageLabel = new JLabel();
        try {
            BufferedImage image = ImageIO.read(new URL(imageUrl));
            Image scaledImage = image.getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(scaledImage);
            imageLabel.setIcon(icon);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageLabel;
    }

    private JLabel createDescriptionLabel(String modelName) {
        JLabel descriptionLabel = new JLabel("<html>" + modelName.replace("\n", "<br>") + "</html>");
        descriptionLabel.setFont(new Font("Arial", Font.BOLD, 18));
        return descriptionLabel;
    }

}

