package exercises;

public class Counter {
    private int value;
    private int max;

    Counter() {
        this(10);
    }

    public Counter(int max) {
        this.value = 0;
        this.max = max;
    }

    public void increment(){
        this.value = value + 1 > this.max ? this.value : this.value + 1;
    }

    public void decrement(){
        this.value = value - 1 < 0 ? this.value : this.value - 1;
    }

    public String toString() {
        return Integer.toString(this.value);
    }
}
