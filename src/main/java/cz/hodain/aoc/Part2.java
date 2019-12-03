package cz.hodain.aoc;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Part2 {

    private static final int EXPECTED_RESULT = 19690720;
    private static Converter<Path, Integer[]> converter = new FileToArrayConverter();
    private static Path inputFilePath = Paths.get("src", "main", "resources", "input.txt");

    public static void main(String[] args) throws Exception {
        Integer[] data = converter.convert(inputFilePath);

        for (int noun = 0; noun <= 99; noun++) {
            for (int verb = 0; verb <= 99; verb++) {
                data[1] = noun;
                data[2] = verb;
                Computer computer = new Computer(data);
                Integer[] restore = computer.restore();
                if (restore[0] == EXPECTED_RESULT) {
                    System.out.format("Result: %s", (100 * restore[1]) + restore[2]);
                    return;
                }
            }
        }
    }

}
