package org.ull.es.dap.factory;

import org.ull.es.dap.brands.audi.VehicleAudi;
import org.ull.es.dap.brands.bmw.SedanBMW;
import org.ull.es.dap.brands.bmw.VehicleBMW;
import org.ull.es.dap.brands.mercedezbenz.VehicleMercedesBenz;

public class SedanFactory implements VehicleFactory {

    @Override
    public VehicleAudi createVehicleAudi() {
        return null;
    }

    @Override
    public VehicleBMW createVehicleBMW() {
        return new SedanBMW();
    }

    @Override
    public VehicleMercedesBenz createVehicleMercedesBenz() {
        return null;
    }
}
