package cz.hodain.aoc;

import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FileToArrayConverterTest {

    private FileToArrayConverter fileToArrayConverter = new FileToArrayConverter();

    @Test
    public void getAsObjectThrowsExceptionIfNullPatameter() throws Exception {
        assertThrows(NullPointerException.class, () -> fileToArrayConverter.convert(null));
    }

    @Test
    public void getAsObjectReturnsEmptyArrayForEmptyFile() throws Exception {
        Path emptyFilePath = Paths.get("src", "test", "resources", "empty.txt");

        assertNotNull(fileToArrayConverter.convert(emptyFilePath));
        assertArrayEquals(new Integer[] {}, fileToArrayConverter.convert(emptyFilePath));
    }

    @Test
    public void getAsObjectReturnsArrayForOneLineFile() throws Exception {
        Path oneLineFilePath = Paths.get("src", "test", "resources", "one_line_input.txt");

        assertNotNull(fileToArrayConverter.convert(oneLineFilePath));
        assertArrayEquals(new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, fileToArrayConverter.convert(oneLineFilePath));
    }

    @Test
    public void getAsObjectReturnsArrayForMultiLineFile() throws Exception {
        Path multiLineFilePath = Paths.get("src", "test", "resources", "multi_line_input.txt");

        assertNotNull(fileToArrayConverter.convert(multiLineFilePath));
        assertArrayEquals(new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, fileToArrayConverter.convert(multiLineFilePath));
    }

}
