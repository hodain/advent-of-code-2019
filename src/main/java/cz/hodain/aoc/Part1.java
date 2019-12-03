package cz.hodain.aoc;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Part1 {

    private static Converter<Path, Integer[]> converter = new FileToArrayConverter();
    private static Path inputFilePath = Paths.get("src", "main", "resources", "input.txt");

    public static void main(String[] args) throws Exception {
        Integer[] data = converter.convert(inputFilePath);
        data[1] = 12;
        data[2] = 2;

        Computer processor = new Computer(data);
        Integer[] restore = processor.restore();
        System.out.format("Result: %s", restore[0]);
    }

}
