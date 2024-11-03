package lotto.view.input.parser;

import java.util.Arrays;
import java.util.List;
import lotto.exception.LottoApplicationException;

public class InputStringParser {

    public static final String DEFAULT_DELIMITER = ",";

    public List<Integer> toIntegerList(String input) {
        return Arrays.stream(input.split(DEFAULT_DELIMITER))
                .map(this::toInt)
                .toList();
    }

    public int toInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new LottoApplicationException("정수를 입력해주세요.");
        }
    }

}
