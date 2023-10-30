package org.ull.es.dap.brands.mercedezbenz;

public class CabrioMercedesBenz implements VehicleMercedesBenz {
    
  private String brand;

	private String type;
	private String model;
	private int year;
	private String fuel;
	double price;

	private String imageURL;

	public CabrioMercedesBenz() {}

	public CabrioMercedesBenz(String brand, String type, String model, int year, String fuel, double price, String imageURL) {
		this.brand = brand;
		this.type = type;
		this.model = model;
		this.year = year;
		this.fuel = fuel;
		this.price = price;
		this.imageURL = imageURL;
	}

	@Override
	public String description() {
		return  "Marca: " + brand + '\n' +
						"Tipo de vehículo: " + type + '\n' +
						"Modelo: " + model + '\n'+
						"Año: " + year + '\n' +
						"Combustible: " + fuel + '\n' +
						"Precio: " + price + '\n';
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
}