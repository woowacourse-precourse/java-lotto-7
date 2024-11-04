package lotto.io.input;

import java.util.List;

public interface Input {

    Integer readLineToInteger();

    List<Integer> readLineToNumbersWithDelimiter(String delimiter);
}
