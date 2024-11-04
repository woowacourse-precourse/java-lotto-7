package lotto.util;



import lotto.domain.Lotto;

public class InputValidator {

    private static final String LOTTO_NUMBER_RANGE_REGEX = "^[1-9]{1}$|^[1-3]{1}[0-9]{1}$|^4{1}[0-5]{1}$";

    public static void validatePurchaseAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위여야 합니다.");
        }
    }

    public static void validateRange(int bonusNumber) {
        Integer parsedNumber = bonusNumber;
        if (!parsedNumber.toString().matches(LOTTO_NUMBER_RANGE_REGEX)) {
            throw new IllegalArgumentException("[ERROR] 숫자의 범위는 1~45까지 입니다.");
        }
    }

    public static void validateDuplicate(Lotto winningLotto, int bonusNumber) {
        boolean hasDuplicate = winningLotto.getNumbers().stream()
                .anyMatch(number -> number == bonusNumber);

        if (hasDuplicate) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
