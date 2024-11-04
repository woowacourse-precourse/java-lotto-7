package lotto.Validator;

import java.util.List;

public class Validator {
    private static final int AMOUNT_UNIT = 1000;
    private static final String VALID_PRICE = "^[0-9]+$";
    private static final int VALID_LOTTO_NUMBER_START = 1;
    private static final int VALID_LOTTO_NUMBER_END = 45;
    private static final int LOTTO_NUMBERS_COUNT = 6;

    public static void validatePurchasePrice(String purchasePrice) {
        if (!purchasePrice.matches(VALID_PRICE) || Integer.parseInt(purchasePrice) % AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위입니다.");
        }
    }

    public static void validateLottoNumbers(List<String> numbers) {
        List<Integer> distinctNumbers = numbers.stream()
                                            .distinct()
                                            .map(Integer::parseInt)
                                            .toList();
        validateLength(distinctNumbers);
        for (Integer number : distinctNumbers) {
            if (number == null || !validateNumber(number)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public static void validateLength(List<Integer> winningNumbers) {
        List<Integer> distinctNumbers = winningNumbers.stream()
                                            .distinct()
                                            .toList();
        if (distinctNumbers.size() != LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public static void validateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (!validateNumber(bonusNumber) || winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public static boolean validateNumber(int number) {
        return number >= VALID_LOTTO_NUMBER_START && number <= VALID_LOTTO_NUMBER_END;
    }
}
