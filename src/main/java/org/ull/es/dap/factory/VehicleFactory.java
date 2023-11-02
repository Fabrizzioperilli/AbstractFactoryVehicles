package org.ull.es.dap.factory;

import org.ull.es.dap.brands.audi.VehicleAudi;
import org.ull.es.dap.brands.bmw.VehicleBMW;
import org.ull.es.dap.brands.mercedezbenz.VehicleMercedesBenz;

public interface VehicleFactory {
    VehicleAudi createVehicleAudi(String brand, String type, String model, int year, String fuel, double price, String imageURL);
    VehicleBMW createVehicleBMW(String brand, String type, String model, int year, String fuel, double price, String imageURL);
    VehicleMercedesBenz createVehicleMercedesBenz(String brand, String type, String model, int year, String fuel, double price, String imageURL);
}
