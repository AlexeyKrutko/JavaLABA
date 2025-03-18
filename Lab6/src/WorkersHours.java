class WorkerHours extends Workers {
    private double hours;

    public WorkerHours(double hours, String name) {
        super(name);
        this.hours = hours;
    }

    @Override
    public double calculate() {
        return 20.8 * 8 * hours;

    }
}

