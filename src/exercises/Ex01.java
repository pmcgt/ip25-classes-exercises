import exercises.Counter;

void main() {
    Counter counter = new Counter(3);
    // increment
    IO.println(counter);
    counter.increment();
    IO.println(counter);
    counter.increment();
    IO.println(counter);
    counter.increment();
    IO.println(counter);
    counter.increment();
    IO.println(counter);

    // decrement
    counter.decrement();
    IO.println(counter);
    counter.decrement();
    IO.println(counter);
    counter.decrement();
    IO.println(counter);
    counter.decrement();
    IO.println(counter);
}

