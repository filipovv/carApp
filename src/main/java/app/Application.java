package app;

import app.models.Car;


/**
 * The Application program implements an application that
 * creates a Car object from Car.class and displays in the console
 * the provided functionality of its public methods.
 */
public class Application {
    public static void main(String[] args) {
        Car car = new Car(
                4,
                5,
                "Black",
                2014,
                "Left",
                5,
                1600,
                4.5);

        System.out.println(car.toString());

        String checkColor = "black";
        System.out.printf("Is car colored %s: %s%n", checkColor, car.isColored(checkColor));

        int checkShift = 5;
        System.out.printf("Is current shift %d: %s%n", checkShift, car.isShiftAs(checkShift));

        System.out.println(car.changeCurrentShiftUp());
        System.out.println(car.changeCurrentShiftDown());

        int addPassengers = 4;
        System.out.printf("Is there space for %d passengers in the car: %s%n", addPassengers, car.isSpaceEnoughForNumberOfPassengers(addPassengers));
        System.out.println("Weight is under 3500: "+car.isWeightUnder3500kg(4, 4));

        int distance = 75;
        System.out.printf("Fuel needed for %dkm - %.2f liters.%n", distance, car.fuelNeededToReachDestination(distance));

    }
}
