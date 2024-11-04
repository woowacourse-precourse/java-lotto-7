package validator;

import java.util.List;

public class BonusNumberValidator {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public static void validate(int bonusNumber, List<Integer> winningNumbers) {
        validateNumberRange(bonusNumber);
        validateNoDuplicates(bonusNumber, winningNumbers);
    }

    private static void validateNumberRange(int bonusNumber) {
        if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private static void validateNoDuplicates(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
        }
    }
}
