package lotto.validator;

public class InputMoneyValidator {

    private static final int LOTTO_PRICE = 1000;

    public static void validatePurchaseMoney(String inputPurchaseMoney) {

        if (!isNumeric(inputPurchaseMoney)) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 양수로 입력해 주세요.");
        }

        if (Long.parseLong(inputPurchaseMoney) % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 " + LOTTO_PRICE + "단위로 입력해 주세요.");
        }
    }

    private static boolean isNumeric(String inputPrice) {
        return inputPrice.chars().allMatch(Character::isDigit);
    }
}
