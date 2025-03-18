abstract class Workers {
    public String name;

    public String getName() {
        return name;
    }

    public Workers(String name) {
        this.name = name;
    }

    public abstract double calculate();
}




