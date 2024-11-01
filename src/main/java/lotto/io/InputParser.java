package lotto.io;

public class InputParser {

    public long convertStringToLong(String input) {
        try {
            return Long.parseLong(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("금액은 정수 형태로 입력해야 합니다.");
        }
    }
}
