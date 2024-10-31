package lotto.model;

public class InputValidator {
    public void validateInputMoney(String input) {
        validateParseNumber(input);
    }

    private void validateParseNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception exception) {
            throw new IllegalArgumentException("[ERROR] 정수를 입력해주세요");
        }
    }

    private void validateDivideByUnit(int input, int price) {
        if (input % price != 0) {
            throw new IllegalArgumentException("[ERROR] " + price + "원 단위의 값을 입력해주세요");
        }
    }
}
