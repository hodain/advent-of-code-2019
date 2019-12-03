package cz.hodain.aoc;

public interface Converter<T, D> {

    D convert(T filePath) throws Exception;

}
