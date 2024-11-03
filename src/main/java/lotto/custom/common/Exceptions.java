package lotto.custom.common;

public class Exceptions {
    public static final String DIGIT_SPACE_DIGIT_REGEX = ".*\\d+\\s+\\d+.*";

    public void emptyInput(String input) {
        if (input == null) {
            throw new IllegalArgumentException(ErrorMessages.NULL_INPUT);
        }
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessages.EMPTY_INPUT);
        }
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessages.WHITESPACE_ONLY);
        }
    }

    public void invalidCharacters(String input, String regexPattern) {
        if (!input.matches(regexPattern)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_CHARACTERS);
        }
    }

    public void integerOverflow(String input) {
        long number = Long.parseLong(input);

        if (number < Integer.MIN_VALUE || number > Integer.MAX_VALUE) {
            throw new IllegalArgumentException(ErrorMessages.INT_OUT_OF_BOUNDS);
        }
    }

    public void spacesBetweenNumbers(String input) {
        if (input.matches(DIGIT_SPACE_DIGIT_REGEX)) {
            throw new IllegalArgumentException(ErrorMessages.SPACES_BETWEEN_NUMBERS);
        }
    }

    public void outOfRange(int number, int rangeStart, int rangeEnd, String errorMessage) {
        if (number < rangeStart || number > rangeEnd) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}