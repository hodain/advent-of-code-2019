package cz.hodain.aoc;

import java.util.Arrays;
import java.util.function.BiFunction;

public class Computer {

    private static final int MULTIPLICATION = 2;
    private static final int ADDTION = 1;
    private static final int EXIT = 99;

    private Integer[] data;
    private int position = 0;

    public Computer(Integer[] data) {
        this.data = Arrays.copyOf(data, data.length);
    }

    public Integer[] restore() {
        while (data[position] != EXIT) {
            data[resultPosition()] = operation().apply(data[opOne()], data[opTwo()]);
            move();
        }
        return data;
    }

    private void move() {
        this.position += 4;
    }

    private int opOne() {
        return data[position + 1];
    }

    private int opTwo() {
        return data[position + 2];
    }

    private int resultPosition() {
        return data[position + 3];
    }

    private BiFunction<Integer, Integer, Integer> operation() {
        switch (data[position]) {
            case ADDTION:
                return (Integer a, Integer b) -> a + b;
            case MULTIPLICATION:
                return (Integer a, Integer b) -> a * b;
            default:
                throw new IllegalStateException(String.format("Unrecognizable operation number %s", data[position]));
        }
    }

}
