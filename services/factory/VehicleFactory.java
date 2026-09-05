package services.factory;
import entities.Bike;
import entities.Car;
import entities.Vehicle;
import enums.VehicleType;

public class VehicleFactory {

    public static Vehicle getVehicle(VehicleType vehicleType, String vehicleNumber){
        if(vehicleType == VehicleType.BIKE){
            return new Bike(vehicleNumber, vehicleType);
        }
        else if(vehicleType == VehicleType.CAR){
            return new Car(vehicleNumber, vehicleType);
        }

        throw new IllegalArgumentException(
            "Unsupported VehicleType: " + vehicleType
        );
    }
}
