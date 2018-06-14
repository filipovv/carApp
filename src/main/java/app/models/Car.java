package app.models;


/**
 * The Car class contains information and properties needed to
 * create a Car object. Via its public methods one can access
 * information about the car, change shifts or calculate fuel
 * consumption for a given trip distance.
 */
public class Car {
    private static final String GEAR_SHIFT = "Manual";
    private static final int MIN_SHIFT = 1;
    private static final int MAX_SHIFT = 5;
    private static final int MIN_SEATS_AMOUNT = 1;
    private static final int MAX_SEATS_AMOUNT = 8;
    private static final int MIN_CAR_WEIGHT = 500;
    private static final int MAX_CAR_WEIGHT = 3500;
    private static final double MIN_FUEL_CONSUMPTION = 3.3;
    private static final double MAX_FUEL_CONSUMPTION = 13.5;
    private static final int AVERAGE_BAG_WEIGHT = 40;
    private static final int AVERAGE_PERSON_WEIGHT = 60;

    private int doors;
    private int seats;
    private String color;
    private int year;
    private SteeringWheelSide steeringWheel;
    private int currentShift;
    private int weight;
    private double consumption;

    /**
     * Constructor for class Car
     *
     * @param doors         Number of door for the car.
     * @param seats         Number of seats in the car.
     * @param color         Color of the car.
     * @param year          Year when the car was manufactured.
     * @param steeringWheel Placement of the steering wheel in the car. Can be Left - Left-Handed, or Right - Right-Handed.
     * @param currentShift  The current shift the car is on right now.
     * @param weight        Weight of the car in kilograms.
     * @param consumption   Average fuel consumption.
     */
    public Car(int doors,
               int seats,
               String color,
               int year,
               String steeringWheel,
               int currentShift,
               int weight,
               double consumption) {
        this.setDoors(doors);
        this.setSeats(seats);
        this.setColor(color);
        this.setYear(year);
        this.setSteeringWheel(steeringWheel);
        this.setCurrentShift(currentShift);
        this.setWeight(weight);
        this.setConsumption(consumption);
    }

    /**
     * Method used to determine if a given color matches the color of the car.
     *
     * @param color The given color to compare with.
     * @return If the given color matches or not.
     */
    public boolean isColored(String color) {
        return color.equalsIgnoreCase(this.getColor());
    }

    /**
     * Method used to determine if a given shift is the same as the current one of the car.
     *
     * @param shift A number that represents a shift to compare with the car one.
     * @return If the given shift matches or not.
     */
    public boolean isShiftAs(int shift) {
        return shift == this.getCurrentShift();
    }

    /**
     * Method used to change the current shift up.
     *
     * @return Message if the shift change was successful ot not.
     */
    public String changeCurrentShiftUp() {
        try {
            this.setCurrentShift(this.getCurrentShift() + 1);
            return "Current shift changed to " + this.getCurrentShift();
        } catch (IndexOutOfBoundsException e) {
            return e.getMessage();
        }
    }

    /**
     * Method used to change the current shift down.
     *
     * @return Message if the shift change was successful or not.
     */
    public String changeCurrentShiftDown() {
        try {
            this.setCurrentShift(this.getCurrentShift() - 1);
            return "Current shift changed to " + this.getCurrentShift();
        } catch (IndexOutOfBoundsException e) {
            return e.getMessage();
        }
    }

    /**
     * Method used to determine if the car will have enough space for a certain number of people, given as a parameter.
     *
     * @param numberOfPassengers Number of people who want to get in the car.
     * @return A boolean value if there is enough space or not.
     */
    public boolean isSpaceEnoughForNumberOfPassengers(int numberOfPassengers) {
        return this.getSeats() - 1 >= numberOfPassengers;
    }

    /**
     * Method used to check if a number of people, bags and the weight of the car itself will exceed 3500kg of weight.
     *
     * @param numberOfBags       Then amount of bags to put in the car.
     * @param numberOfPassengers The number of people to add in calculation.
     * @return A boolean value to see if the total weight calculated is under 3500kg or not.
     */
    public boolean isWeightUnder3500kg(int numberOfBags, int numberOfPassengers) {
        int totalAddedWeight = numberOfBags * AVERAGE_BAG_WEIGHT + numberOfPassengers * AVERAGE_PERSON_WEIGHT;
        return this.getWeight() + totalAddedWeight < 3500;
    }

    /**
     * Method used to calculate the fuel needed to make a trip with a given destination distance.
     *
     * @param destinationDistance The distance in kilometers to a destination.
     * @return A double value representing the amount of fuel needed.
     */
    public double fuelNeededToReachDestination(int destinationDistance) {
        return this.getConsumption() / 100 * destinationDistance;
    }

    /**
     * toString method of the Car class.
     *
     * @return String value providing a summed up information about the object.
     */
    @Override
    public String toString() {
        return String.format("Car info:%n" +
                        "Doors: %d%n" +
                        "Seats: %d%n" +
                        "Color: %s%n" +
                        "Year Created: %d%n" +
                        "Steering Wheel: %s%n" +
                        "Gear Shifts: %s%n" +
                        "Current Shift: %d%n" +
                        "Weight: %d%n" +
                        "Consumption: %.2f%n",
                this.getDoors(), this.getSeats(), this.getColor(), this.getYear(), this.getSteeringWheel(), this.getGearShift(), this.getCurrentShift(), this.getWeight(), this.getConsumption());
    }

    /**
     * Get method for the doors.
     *
     * @return Integer value representing number of door in the car.
     */
    public int getDoors() {
        return this.doors;
    }

    /**
     * Setter method for doors.
     *
     * @param doors Integer value to be set as doors value.
     */
    private void setDoors(int doors) {
        this.doors = doors;
    }

    /**
     * Getter method for seats.
     *
     * @return Integer value representing the number of seats in car.
     */
    public int getSeats() {
        return this.seats;
    }

    /**
     * Setter method for seats.
     *
     * @param seats Integer value to be set as number of seats in the car.
     */
    private void setSeats(int seats) {
        if (seats > MAX_SEATS_AMOUNT) {
            throw new IllegalArgumentException("Seat amount cannot exceed " + MAX_SEATS_AMOUNT + ".");
        } else if (seats < MIN_SEATS_AMOUNT) {
            throw new IllegalArgumentException("Seats amount cannot be lower than " + MIN_SEATS_AMOUNT + ".");
        } else {
            this.seats = seats;
        }
    }

    /**
     * Getter method for color.
     *
     * @return String value representing the color of the car.
     */
    public String getColor() {
        return this.color;
    }

    /**
     * Setter method for color.
     *
     * @param color String value to be set as a color of the car.
     */
    private void setColor(String color) {
        this.color = color;
    }

    /**
     * Getter method for year or production.
     *
     * @return Integer value representing the year of production of the car.
     */
    public int getYear() {
        return this.year;
    }

    /**
     * Setter method for year of production.
     *
     * @param year Integer value to be set as year of production of the car.
     */
    private void setYear(int year) {
        this.year = year;
    }

    /**
     * Getter method for steering wheel side.
     *
     * @return Enum value representing the side of the steering wheel in the car.
     */
    public SteeringWheelSide getSteeringWheel() {
        return this.steeringWheel;
    }

    /**
     * Setter method for steering wheel side.
     *
     * @param steeringWheel String value of the side of the steering wheel. Can only be Left or Right.
     */
    private void setSteeringWheel(String steeringWheel) {
        if (!"left".equalsIgnoreCase(steeringWheel) && !"right".equalsIgnoreCase(steeringWheel)) {
            throw new IllegalArgumentException("Steering wheel can only be left-handed or right-handed.");
        } else {
            this.steeringWheel = SteeringWheelSide.valueOf(steeringWheel.toUpperCase());
        }
    }

    /**
     * Getter method for the gear shift of the car.
     *
     * @return String value representing gear shift type.
     */
    public String getGearShift() {
        return GEAR_SHIFT;
    }

    /**
     * Getter method of the current shift.
     *
     * @return Integer value representing the current shift the car is on right now.
     */
    public int getCurrentShift() {
        return this.currentShift;
    }

    /**
     * Setter method of the current shift.
     *
     * @param currentShift Integer value to be set as current shift.
     */
    private void setCurrentShift(int currentShift) {
        if (currentShift > MAX_SHIFT) {
            throw new IndexOutOfBoundsException("Cannot set higher shift than the maximum(" + MAX_SHIFT + ").");
        } else if (currentShift < MIN_SHIFT) {
            throw new IndexOutOfBoundsException("Cannot set lower shift than the minimum(" + MIN_SHIFT + ").");
        } else {
            this.currentShift = currentShift;
        }
    }

    /**
     * Getter method for weight of the car.
     *
     * @return Integer value representing the weight of the car.
     */
    public int getWeight() {
        return this.weight;
    }

    /**
     * Setter method for weight.
     *
     * @param weight Integer value to be set as weight of the car.
     */
    private void setWeight(int weight) {
        if (weight > MAX_CAR_WEIGHT) {
            throw new IllegalArgumentException("Car weight cannot exceed " + MAX_CAR_WEIGHT + ".");
        } else if (weight < MIN_CAR_WEIGHT) {
            throw new IllegalArgumentException("Car weight cannot be lower than " + MIN_CAR_WEIGHT + ".");
        } else {
            this.weight = weight;
        }
    }

    /**
     * Getter method for field consumption.
     *
     * @return Double value representing the average fuel consumption of the car.
     */
    public double getConsumption() {
        return this.consumption;
    }

    /**
     * Setter method for fuel consumption.
     *
     * @param consumption Double value to be set as fuel consumption of the car.
     */
    private void setConsumption(double consumption) {
        if (consumption > MAX_FUEL_CONSUMPTION) {
            throw new IllegalArgumentException("Fuel consumption cannot exceed " + MAX_FUEL_CONSUMPTION + ".");
        } else if (consumption < MIN_FUEL_CONSUMPTION) {
            throw new IllegalArgumentException("Fuel consumption cannot be lower that " + MIN_FUEL_CONSUMPTION + ".");
        } else {
            this.consumption = consumption;
        }
    }
}
