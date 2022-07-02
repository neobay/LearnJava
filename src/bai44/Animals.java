package bai44;

public class Animals {
    private String name;
    private String species;
    private float height;
    private float weight;
    private String habitat;
    private String birthForm;

    public Animals() {
    }

    public Animals(String name, String species, float height, float weight, String habitat, String birthForm) {
        this.name = name;
        this.species = species;
        this.height = height;
        this.weight = weight;
        this.habitat = habitat;
        this.birthForm = birthForm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getBirthForm() {
        return birthForm;
    }

    public void setBirthForm(String birthForm) {
        this.birthForm = birthForm;
    }
    public void eat(){
        System.out.println(name + "dang an....");
    }
    public void sleep(){
        System.out.println(name + "dang ngu...");
    }
    public void move(){
        System.out.println(name + "dang di chuyen...");
    }
    public void relax(){
        System.out.println(name + "dang nghi ngoi...");
    }
}
