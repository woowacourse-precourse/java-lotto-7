package lotto.validator;

public class LottoValidator {

    public static void validateInputMoney(String inputMoney) {
        if (inputMoney == null || inputMoney.isEmpty()) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < inputMoney.length(); i++) {
            if (!Character.isDigit(inputMoney.charAt(i))) {
                throw new IllegalArgumentException();
            }
        }
        int money = Integer.parseInt(inputMoney);
        if (money % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }
}