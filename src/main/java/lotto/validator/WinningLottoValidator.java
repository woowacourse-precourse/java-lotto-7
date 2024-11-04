package lotto.validator;

import static lotto.util.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.util.LottoConstants.MIN_LOTTO_NUMBER;
import static lotto.util.LottoConstants.REQUIRED_LOTTO_NUMBER_COUNT;

import java.util.List;

public class WinningLottoValidator {

    public static void validate(List<Integer> winningNumbers, int bonusNumber) {
        validateNumberCount(winningNumbers);
        validateNumberRange(winningNumbers);
        validateBonusNumberRange(bonusNumber);
        validateNoDuplicateNumbers(winningNumbers);
        validateBonusNumberDuplicate(winningNumbers, bonusNumber);
    }

    private static void validateNumberCount(List<Integer> winningNumbers) {
        if (winningNumbers.size() != REQUIRED_LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 정확히 6개여야 합니다.");
        }
    }

    private static void validateNumberRange(List<Integer> winningNumbers) {
        for (int number : winningNumbers) {
            if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private static void validateNoDuplicateNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != winningNumbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
        }
    }

    private static void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private static void validateBonusNumberDuplicate(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
