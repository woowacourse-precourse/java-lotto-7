package lotto.validator;

public class LottoValidator {

    public static void validateInputMoney(String inputMoney) {
        if (inputMoney == null || inputMoney.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (!inputMoney.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException();
        }
        int money = Integer.parseInt(inputMoney);
        if (money % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }
}