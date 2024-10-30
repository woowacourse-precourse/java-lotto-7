package lotto.common.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StringSplitter {

    private static final String COMMA = ",";

    private StringSplitter() {
    }

    public static List<String> split(final String target, final String delimiter) {
        validate(target, delimiter);
        return Stream.of(target.split(delimiter))
                .map(String::trim)
                .toList();
    }

    public static List<String> splitByComma(final String target) {
        return split(target, COMMA);
    }

    private static void validate(final String target, final String delimiter) {
        checkNullOrEmpty(target);
        checkDelimitedPattern(target, delimiter);
    }

    private static void checkNullOrEmpty(final String target) {
        if (target == null || target.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 입력은 빈 값일 수 없습니다.");
        }
    }

    private static void checkDelimitedPattern(final String target, final String delimiter) {
        Arrays.stream(target.split(delimiter, -1))
                .forEach(part -> {
                    if (part.trim().isEmpty()) {
                        throw new IllegalArgumentException("[ERROR] 올바르지 않은 입력 형식입니다.");
                    }
                });
    }
}
