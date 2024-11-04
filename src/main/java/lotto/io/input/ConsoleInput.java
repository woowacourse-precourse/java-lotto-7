package lotto.io.input;

import java.util.List;
import lotto.util.StringParser;

public class ConsoleInput implements Input {

    private final InputReader inputReader;
    private final StringParser stringParser;

    public ConsoleInput(InputReader inputReader, StringParser stringParser) {
        this.inputReader = inputReader;
        this.stringParser = stringParser;
    }

    @Override
    public Integer readLineToInteger() {
        return stringParser.parseStringToInteger(inputReader.readLine());
    }

    @Override
    public List<Integer> readLineToNumbersWithDelimiter(String delimiter) {
        return stringParser.parseStringToNumbers(inputReader.readLine(), delimiter);
    }

}
