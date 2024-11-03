package lotto.support.splitter;

import java.util.Arrays;
import java.util.List;
import lotto.exception.splitter.InvalidTextException;

public class Splitter {

    private final String delimiter;

    public Splitter(final String delimiter) {
        this.delimiter = delimiter;
    }

    public List<String> split(final String text) {
        validate(text);
        return Arrays.asList(text.split(delimiter, -1));
    }

    private void validate(final String text) {
        if (text == null) {
            throw new InvalidTextException("null일 수 없습니다");
        }
        if (text.isBlank()) {
            throw new InvalidTextException("빈 문자열이거나 공백일 수 없습니다");
        }
    }
}
