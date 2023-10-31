package org.ull.es.dap.factory;

import org.ull.es.dap.brands.audi.SedanAudi;
import org.ull.es.dap.brands.audi.VehicleAudi;
import org.ull.es.dap.brands.bmw.SedanBMW;
import org.ull.es.dap.brands.bmw.VehicleBMW;
import org.ull.es.dap.brands.mercedezbenz.SedanMercedesBenz;
import org.ull.es.dap.brands.mercedezbenz.VehicleMercedesBenz;

public class SedanFactory implements VehicleFactory {

    @Override
    public VehicleAudi createVehicleAudi(String brand, String type, String model, int year, String fuel, double price, String imageURL) {
        return new SedanAudi(brand, type, model, year, fuel, price, imageURL);
    }

    @Override
    public VehicleBMW createVehicleBMW(String brand, String type, String model, int year, String fuel, double price, String imageURL) {
            return new SedanBMW(brand, type, model, year, fuel, price, imageURL);
    }

    @Override
    public VehicleMercedesBenz createVehicleMercedesBenz(String brand, String type, String model, int year, String fuel, double price, String imageURL) {
        return new SedanMercedesBenz(brand, type, model, year, fuel, price, imageURL);
    }
}
