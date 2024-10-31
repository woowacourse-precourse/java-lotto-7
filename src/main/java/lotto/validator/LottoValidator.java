package lotto.validator;

public class LottoValidator {

    public static void validateInputMoney(String inputMoney) {
        isEmpty(inputMoney);
        isDigit(inputMoney);
        int money = Integer.parseInt(inputMoney);
        if (money % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    private static void isEmpty(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private static void isDigit(String inputMoney) {
        if (!inputMoney.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException();
        }
    }
}