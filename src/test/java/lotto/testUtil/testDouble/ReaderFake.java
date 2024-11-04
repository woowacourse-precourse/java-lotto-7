package lotto.testUtil.testDouble;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.io.reader.Reader;

public class ReaderFake implements Reader {

    private final List<String> inputs = new ArrayList<>();
    private int inputCounter = 0;

    public void setInput(String... input) {
        this.inputs.addAll(List.of(input));
    }

    @Override
    public List<Integer> readLineAsNumbers(String spliter) {
        String input = getNextInput();
        return Arrays.stream(input.split(spliter))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }

    @Override
    public int readLineAsNumber() {
        return Integer.parseInt(getNextInput());
    }

    private String getNextInput() {
        return inputs.get(inputCounter++);
    }
}
