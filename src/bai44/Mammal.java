package bai44;

public class Mammal extends Animals{
    private int numOfLegs;
    private String color;
    private int numOfTeeth;
    private String behavior;

    public Mammal() {
    }

    public Mammal(int numOfLegs, String color, int numOfTeeth, String behavior) {
        this.numOfLegs = numOfLegs;
        this.color = color;
        this.numOfTeeth = numOfTeeth;
        this.behavior = behavior;
    }

    public Mammal(String name, String species, float height, float weight, String habitat, String birthForm, int numOfLegs, String color, int numOfTeeth, String behavior) {
        super(name, species, height, weight, habitat, birthForm);
        this.numOfLegs = numOfLegs;
        this.color = color;
        this.numOfTeeth = numOfTeeth;
        this.behavior = behavior;
    }

    public int getNumOfLegs() {
        return numOfLegs;
    }

    public void setNumOfLegs(int numOfLegs) {
        this.numOfLegs = numOfLegs;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumOfTeeth() {
        return numOfTeeth;
    }

    public void setNumOfTeeth(int numOfTeeth) {
        this.numOfTeeth = numOfTeeth;
    }

    public String getBehavior() {
        return behavior;
    }

    public void setBehavior(String behavior) {
        this.behavior = behavior;
    }
}
