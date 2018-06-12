package app;

import app.models.Car;

public class Application {
    public static void main(String[] args) {
        Car car = new Car(4, 5, "Black", 2014, "Left-Handed", "Manual", 4, 1600, 4.5);

        car.printAllInfo();

        String checkColor = "black";
        System.out.printf("Is car colored %s: %s%n", checkColor, car.isColored(checkColor));

        int checkShift = 5;
        System.out.printf("Is current shift %d: %s%n", checkShift, car.isShiftAs(checkShift));

        car.changeCurrentShiftUp();
        car.changeCurrentShiftDown();

        int addPassengers = 4;
        System.out.printf("Is there space for %d passengers in the car: %s%n", addPassengers, car.isSpaceEnoughForNumberOfPassengers(addPassengers));
        System.out.println("Weight is under 3500: "+car.isWeightUnder3500kg(4, 4));

        int distance = 75;
        System.out.printf("Fuel needed for %dkm - %.2f%n", distance, car.fuelNeededToReachDestination(distance));
    }
}
