class WorkerFix extends Workers {
    private double salary;

    public WorkerFix(double salary, String name) {
        super(name);
        this.salary = salary;
    }

    @Override
    public double calculate() {
        return salary;
    }
}

