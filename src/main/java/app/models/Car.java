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

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getSteeringWheel() {
        return steeringWheel;
    }

    public void setSteeringWheel(String steeringWheel) {
        this.steeringWheel = steeringWheel;
    }

    public String getGearShift() {
        return gearShift;
    }

    public void setGearShift(String gearShift) {
        this.gearShift = gearShift;
    }

    public int getCurrentShift() {
        return currentShift;
    }

    public void setCurrentShift(int currentShift) {
        this.currentShift = currentShift;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }
}
