package lotto.util;

public class Validator {
    public static void validateWhitespaceInput(String input) {
        if (input.startsWith(" ") || input.endsWith(" ")) {
            throw new IllegalArgumentException("[ERROR] 입력값은 공백으로 시작하거나 끝날 수 없습니다.");
        }
    }

    public static void validateNullInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력값은 빈 문자열이 될 수 없습니다.");
        }
    }

    public int validateLottoNumber(String number) {
        try {
            validateRightNumber(number);
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 문자는 입력할 수 없습니다.");
        }
    }

    public void validateRightNumber(String number) {
        if (number.charAt(0) == '0') {
            throw new IllegalArgumentException("[ERROR] 올바른 형식의 숫자를 입력해주세요.");
        }
    }

    public void validateRightDelimiter(String input) {
        if (input.startsWith(InputUtil.DELIMITER) || input.endsWith(InputUtil.DELIMITER)) {
            throw new IllegalArgumentException("[ERROR] 구분자는 반드시 숫자 사이에 있어야합니다.");
        }
    }
}
