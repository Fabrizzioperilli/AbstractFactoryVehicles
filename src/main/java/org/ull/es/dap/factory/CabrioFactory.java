package org.ull.es.dap.factory;

import org.ull.es.dap.brands.audi.CabrioAudi;
import org.ull.es.dap.brands.audi.VehicleAudi;
import org.ull.es.dap.brands.bmw.CabrioBMW;
import org.ull.es.dap.brands.bmw.VehicleBMW;
import org.ull.es.dap.brands.mercedezbenz.CabrioMercedesBenz;
import org.ull.es.dap.brands.mercedezbenz.VehicleMercedesBenz;

public class CabrioFactory implements VehicleFactory {

    @Override
    public VehicleAudi createVehicleAudi(String brand, String type, String model, int year, String fuel, double price, String imageURL) {
        return new CabrioAudi(brand, type, model, year, fuel, price, imageURL);
    }

    @Override
    public VehicleBMW createVehicleBMW(String brand, String type, String model, int year, String fuel, double price, String imageURL) {
        return new CabrioBMW(brand, type, model, year, fuel, price, imageURL);
    }

    @Override
    public VehicleMercedesBenz createVehicleMercedesBenz(String brand, String type, String model, int year, String fuel, double price, String imageURL) {
        return new CabrioMercedesBenz(brand, type, model, year, fuel, price, imageURL);
    }
}
