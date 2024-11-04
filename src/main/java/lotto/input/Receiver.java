package lotto.input;

public interface Receiver <T> {

    T receiveWithMessage();

    default void validateEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 빈 입력은 불가능합니다.");
        }
    }

    default void validateNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (isNotDigit(input.charAt(i))) {
                throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다. 입력한 값 : " + input);
            }
        }
    }

    private boolean isNotDigit(char number) {
        return !Character.isDigit(number);
    }
}
