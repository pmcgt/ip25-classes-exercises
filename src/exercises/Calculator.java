package exercises;

public class Calculator {
    private double value = 0;
    private double lastValue = 0;

    public double value() {
        return Math.round(this.value * 1000.0) / 1000.0;
    }

    public void add(double num) {
        this.lastValue = this.value;
        this.value = value + num;
    }

    public void subtract(double num) {
        this.lastValue = this.value;
        this.value = value - num;
    }

    public void multiply(double num) {
        this.lastValue = this.value;
        this.value = value * num;
    }

    public void divide(double num) {
        if(num == 0) {
            IO.println("Dividing by zero is a bad idea");
            return;
        }
        this.lastValue = this.value;
        this.value = value / num;
    }

    public void reset() {
        this.lastValue = this.value;
        this.value = 0;
    }

    public void undo() {
        this.value = this.lastValue;
    }

}
