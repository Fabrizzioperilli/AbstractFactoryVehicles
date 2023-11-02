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
import java.util.ArrayList;
import java.util.List;

public class BrandWindow extends JFrame {

  private JLabel titleLabel;

  public BrandWindow(String typeVehicle) {

    super(typeVehicle);
    getContentPane().setBackground(Color.WHITE);
    initializeUI();
    addTitleLabel(typeVehicle);
    Parser dataBrands = new ParserBrands(new CSVReader("https://docs.google.com/spreadsheets/d/e/2PACX-1vQx_cgEFGrE7Y92T3bQNfDbVq0z2v_vY0fFmXDW9XSvNb46fKwuRthwcENnTDUBB9xy-ssNlC0wW_kT/pub?output=csv"));
    addLogoLabel(dataBrands, 240, 240);

    addAudiBrand(typeVehicle);
    addBMWBrand(typeVehicle);
    addMercedesBenzBrand(typeVehicle);


  }

private void initializeUI() {
  setLayout(null);
  setResizable(false);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setSize(1000, 700);
  setLocationRelativeTo(null);
  setVisible(true);
}

private void addTitleLabel(String typeVehicle) {
  titleLabel = new JLabel("Seleccione una marca del tipo " + typeVehicle);
  titleLabel.setBounds(110, 20, 1000, 160);
  titleLabel.setFont(new Font("Arial", Font.BOLD, 42));
  add(titleLabel);
}

  private void addAudiBrand(String typeVehicle) {
    JButton audiButton = new JButton("Audi");
    add(audiButton);
    audiButton.setBounds(90, 480, 200, 50);  // Configura la posición y el tamaño del botón Audi
    audiButton.addActionListener(e -> openVehicleWindow(typeVehicle, "Audi"));
  }

  private void addBMWBrand(String typeVehicle) {
    JButton bmwButton = new JButton("BMW");
    add(bmwButton);
    bmwButton.setBounds(370, 480, 200, 50);  // Configura la posición y el tamaño del botón BMW
    bmwButton.addActionListener(e -> openVehicleWindow(typeVehicle, "BMW"));
  }

  private void addMercedesBenzBrand(String typeVehicle) {
    JButton mercedesButton = new JButton("MercedesBenz");
    add(mercedesButton);
    mercedesButton.setBounds(650, 480, 200, 50); // Configura la posición y el tamaño del botón Mercedes Benz
    mercedesButton.addActionListener(e -> openVehicleWindow(typeVehicle, "Mercedes Benz"));
  }

  private void openVehicleWindow(String typeVehicle, String brand) {
    VehicleWindow vehiclewindow = new VehicleWindow(typeVehicle, brand);
    vehiclewindow.setVisible(true);
    this.dispose(); // Cierra la segunda ventana
  }

  private void addLogoLabel(Parser dataBrands, int newWidth, int newHeight) {
    List<String> imageUrls = new ArrayList<>();
    for (List<Object> rowData : dataBrands.getData()) {
      String imageUrl = (String) rowData.get(1);
      imageUrls.add(imageUrl);
    }
    int x = 80; // Coordenada x inicial
    int y = 220;  // Coordenada y inicial

    for (String imageUrl : imageUrls) {
      try {
        ImageIcon originalIcon = new ImageIcon(new URL(imageUrl));
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel logoLabel = new JLabel(scaledIcon);
        logoLabel.setBounds(x, y, newWidth, newHeight);
        add(logoLabel);

        // Actualiza las coordenadas para la siguiente imagen
        x += 270; // Espacio horizontal entre las imágenes
      } catch (MalformedURLException e) {
        throw new RuntimeException(e);
      }
    }
  }

}