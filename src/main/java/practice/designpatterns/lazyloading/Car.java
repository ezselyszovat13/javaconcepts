package practice.designpatterns.lazyloading;

import java.util.Map;
import java.util.HashMap;

public class Car {
    private static Map<CarType, Car> types = new HashMap<>();

    private Car(CarType carType) {}

    public static Car getCarByTypeName(CarType type){
        Car car;
        if(!types.containsKey(type)){
            car = new Car(type);
            types.put(type, car);
        } else {
            car = types.get(type);
        }
        return car;
    }

    public static String getAllCars(){
        return types.keySet().toString();
    }
}
