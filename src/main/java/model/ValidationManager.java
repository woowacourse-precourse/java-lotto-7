package model;

public class ValidationManager {

    public final String NON_NUMERIC_ERROR = "[ERROR]숫자 이외의 한글,알파벳,특수문자 등을 허용하지 않습니다.";
    public final String EMPTY_INPUT_ERROR = "[ERROR]빈문자열입니다. 다시 입력해주세요.";
    public final String NOT_DIVISIBLE_BY_THOUSAND_ERROR = "[ERROR]1000원 단이가 아닙니다. 다시 입력해주세요.";
    private final int amountDivisor = 1000;

    public boolean isNumber(String userInput, String errorMessage) {
        if (userInput.chars().allMatch(Character::isDigit)) {
            return true;
        }
        throw new IllegalArgumentException(errorMessage);
    }

    public boolean isEmptyInput(String userInput, String errorMessage) {
        if (userInput.isEmpty()) {
            return true;
        }
        throw new IllegalArgumentException(errorMessage);
    }

    public boolean isDivideByThousand(String userInput, String errorMessage) {
        if (Integer.parseInt(userInput) % amountDivisor == 0) {
            return true;
        }
        throw new IllegalArgumentException(errorMessage);
    }

}
