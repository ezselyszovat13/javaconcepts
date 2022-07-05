package practice.designpatterns.lazyloading;

public class Program {
    public static void main(String[] args)
    {
        Car.getCarByTypeName(CarType.BMW);
        System.out.println(Car.getAllCars());
        Car.getCarByTypeName(CarType.Audi);
        System.out.println(Car.getAllCars());
        Car.getCarByTypeName(CarType.BMW);
        System.out.println(Car.getAllCars());
    }
}
