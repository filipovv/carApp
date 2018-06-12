package app.models;

public class Car {
    private int doors;
    private int seats;
    private String color;
    private int year;
    private String steeringWheel;
    private String gearShift;
    private int currentShift;
    private int weight;
    private double consumption;

    public Car(int doors, int seats, String color, int year, String steeringWheel, String gearShift, int currentShift, int weight, double consumption) {
        this.setDoors(doors);
        this.setSeats(seats);
        this.setColor(color);
        this.setYear(year);
        this.setSteeringWheel(steeringWheel);
        this.setGearShift(gearShift);
        this.setCurrentShift(currentShift);
        this.setWeight(weight);
        this.setConsumption(consumption);
    }

    public void printAllInfo() {
        System.out.printf("Car info:%n" +
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

    public boolean isColored(String color) {
        return color.equalsIgnoreCase(this.getColor());
    }

    public boolean isShiftAs(int shift) {
        return shift==this.getCurrentShift();
    }

    public void changeCurrentShiftUp() {
        this.currentShift++;
        System.out.println("Current shift changed to "+this.getCurrentShift());
    }

    public void changeCurrentShiftDown() {
        System.out.println("Current shift changed to "+ --this.currentShift);
    }

    public boolean isSpaceEnoughForNumberOfPassengers(int numberOfPassengers) {
        return this.getSeats()-1>=numberOfPassengers;
    }

    public boolean isWeightUnder3500kg(int numberOfBags, int numberOfPassengers) {
        int totalAddedWeight = numberOfBags*40+numberOfPassengers*60;
        return this.getWeight()+totalAddedWeight<3500;
    }

    public double fuelNeededToReachDestination(int destinationDistance) {
        return this.getConsumption()/100*destinationDistance;
    }

    public int getDoors() {
        return doors;
    }

    private void setDoors(int doors) {
        this.doors = doors;
    }

    public int getSeats() {
        return seats;
    }

    private void setSeats(int seats) {
        this.seats = seats;
    }

    public String getColor() {
        return color;
    }

    private void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    private void setYear(int year) {
        this.year = year;
    }

    public String getSteeringWheel() {
        return steeringWheel;
    }

    private void setSteeringWheel(String steeringWheel) {
        this.steeringWheel = steeringWheel;
    }

    public String getGearShift() {
        return gearShift;
    }

    private void setGearShift(String gearShift) {
        this.gearShift = gearShift;
    }

    public int getCurrentShift() {
        return currentShift;
    }

    private void setCurrentShift(int currentShift) {
        this.currentShift = currentShift;
    }

    public int getWeight() {
        return weight;
    }

    private void setWeight(int weight) {
        this.weight = weight;
    }

    public double getConsumption() {
        return consumption;
    }

    private void setConsumption(double consumption) {
        this.consumption = consumption;
    }
}
