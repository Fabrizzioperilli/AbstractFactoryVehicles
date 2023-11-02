package org.ull.es.dap.factory;

import org.ull.es.dap.brands.audi.SUVAudi;
import org.ull.es.dap.brands.audi.VehicleAudi;
import org.ull.es.dap.brands.bmw.SUVBMW;
import org.ull.es.dap.brands.bmw.VehicleBMW;
import org.ull.es.dap.brands.mercedezbenz.SUVMercedesBenz;
import org.ull.es.dap.brands.mercedezbenz.VehicleMercedesBenz;

public class SUVFactory implements VehicleFactory {

    @Override
    public VehicleAudi createVehicleAudi(String brand, String type, String model, int year, String fuel, double price, String imageURL) {
        return new SUVAudi(brand, type, model, year, fuel, price, imageURL);
    }

    @Override
    public VehicleBMW createVehicleBMW(String brand, String type, String model, int year, String fuel, double price, String imageURL) {
        return new SUVBMW(brand, type, model, year, fuel, price, imageURL);
    }

    @Override
    public VehicleMercedesBenz createVehicleMercedesBenz(String brand, String type, String model, int year, String fuel, double price, String imageURL) {
            return new SUVMercedesBenz(brand, type, model, year, fuel, price, imageURL);
    }
}