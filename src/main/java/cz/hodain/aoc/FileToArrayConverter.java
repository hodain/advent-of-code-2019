package cz.hodain.aoc;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

public class FileToArrayConverter implements Converter<Path, Integer[]> {

    public Integer[] convert(Path filePath) throws Exception {
        Objects.requireNonNull(filePath);

        try (Stream<String> lines = Files.lines(filePath);) {
            return lines
                .map(line -> line.split(","))
                .flatMap(Arrays::stream)
                .map(Integer::valueOf)
                .toArray(Integer[]::new);
        }
    }

}
