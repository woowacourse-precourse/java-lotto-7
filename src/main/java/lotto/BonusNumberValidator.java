package lotto;

import static lotto.LottoConstants.MAX_NUMBER;
import static lotto.LottoConstants.MIN_NUMBER;

public class BonusNumberValidator {
    private final int bonusNumber;

    public BonusNumberValidator(int bonusNumber, Lotto winningLotto) {
        validateBonusNumber(bonusNumber, winningLotto);
        this.bonusNumber = bonusNumber;
    }

    private static boolean isValidRange(int number) {
        return number >= MIN_NUMBER.getValue() && number <= MAX_NUMBER.getValue();
    }

    private static boolean isBonusNumberInWinningNumbers(int number, Lotto winningLotto) {
        return winningLotto.getLottoNumbers().contains(number);
    }

    private static void validateBonusNumber(int number, Lotto winningLotto) {
        if (!isValidRange(number)) {
            throw new IllegalArgumentException("[ERROR] 1 - 45 사이의 수를 입력하세요.");
        }
        if (isBonusNumberInWinningNumbers(number, winningLotto)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호에 포함되지 않은 수를 입력하세요.");
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
