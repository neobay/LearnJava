package Bai55;

public abstract class Vehicle {
    private String brand;
    private int year;
    private String madeIn;
    private float price;
    private String size;
    private float weight;
    private String licensePlate;

    public Vehicle() {
    }

    public Vehicle(String brand, int year, String madeIn, float price, String size, float weight, String licensePlate) {
        this.brand = brand;
        this.year = year;
        this.madeIn = madeIn;
        this.price = price;
        this.size = size;
        this.weight = weight;
        this.licensePlate = licensePlate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMadeIn() {
        return madeIn;
    }

    public void setMadeIn(String madeIn) {
        this.madeIn = madeIn;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
    public abstract void startEngine();
    public abstract void stopEngine();
    public abstract void speedUp();
    public abstract void brake();
    public abstract void turnLight();
}
