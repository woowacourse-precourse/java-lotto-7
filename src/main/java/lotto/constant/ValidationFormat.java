package lotto.constant;

public enum ValidationFormat {
    ZERO("0"),
    MINUS_NUMBER_REGEX("-\\d+"),
    DIGIT_NUMBER_REGEX("\\d+"),
    DELIMITER(",");

    private final String message;

    ValidationFormat(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }

}
