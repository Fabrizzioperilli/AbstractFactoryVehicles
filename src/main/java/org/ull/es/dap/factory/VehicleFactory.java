package org.ull.es.dap.factory;

import org.ull.es.dap.brands.audi.VehicleAudi;
import org.ull.es.dap.brands.bmw.VehicleBMW;
import org.ull.es.dap.brands.mercedezbenz.VehicleMercedesBenz;

public interface VehicleFactory {
    VehicleAudi createVehicleAudi();
    VehicleBMW createVehicleBMW();
    VehicleMercedesBenz createVehicleMercedesBenz();
}
