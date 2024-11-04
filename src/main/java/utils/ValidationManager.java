package utils;

public class ValidationManager {

    private static final String NON_NUMERIC_ERROR = "[ERROR] 숫자 이외의 한글,알파벳,특수문자 등을 허용하지 않습니다.";
    private static final String EMPTY_INPUT_ERROR = "[ERROR] 입력이 되지 않았습니다.";
    private static final String LOTTO_DELIMITER_COMMA_ERROR = "[ERROR] 로또 번호는 (2,3,4,5) 이런 형태로 숫자와 쉼표가 번갈아 입력되어 구분되어야합니다.";


    public static boolean isNumber(String userInput) {
        if (userInput.chars().allMatch(Character::isDigit)) {
            return true;
        }
        throw new IllegalArgumentException(NON_NUMERIC_ERROR);
    }

    public static boolean isNotEmptyInput(String userInput) {
        if (!userInput.isEmpty()) {
            return true;
        }
        throw new IllegalArgumentException(EMPTY_INPUT_ERROR);
    }

    public static boolean isNumbersDividedByComma(String userInput) {
        if (userInput.matches("\\d{1,2}(,\\d{1,2})*")) {
            return true;
        }
        throw new IllegalArgumentException(LOTTO_DELIMITER_COMMA_ERROR);
    }

}
