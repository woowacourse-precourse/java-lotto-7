package lotto.support.splitter;

import java.util.Arrays;
import java.util.List;
import lotto.support.validator.InputValidator;

public class Splitter {

    private final String delimiter;

    public Splitter(final String delimiter) {
        this.delimiter = delimiter;
    }

    public List<String> split(final String text) {
        InputValidator.validateNotNullOrBlank(text, "입력 문자열");
        return Arrays.asList(text.split(delimiter, -1));
    }
}
