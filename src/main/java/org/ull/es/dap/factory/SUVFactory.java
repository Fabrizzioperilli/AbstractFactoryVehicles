package org.ull.es.dap.factory;

import org.ull.es.dap.brands.audi.VehicleAudi;
import org.ull.es.dap.brands.bmw.VehicleBMW;
import org.ull.es.dap.brands.mercedezbenz.VehicleMercedesBenz;

public class SUVFactory implements VehicleFactory {

    @Override
    public VehicleAudi createVehicleAudi() {
        return null;
    }

    @Override
    public VehicleBMW createVehicleBMW() {
        return null;
    }

    @Override
    public VehicleMercedesBenz createVehicleMercedesBenz() {
        return null;
    }
}
