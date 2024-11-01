package model;

public class ValidationManager {

    private final String AMOUNT_NON_NUMERIC_ERROR = "[ERROR]금액에는 숫자 이외의 한글,알파벳,특수문자 등을 허용하지 않습니다.";

    public boolean isNumber(String userInput) {
        if (userInput.chars().allMatch(Character::isDigit)) {
            return true;
        }
        return false;
    }

}
