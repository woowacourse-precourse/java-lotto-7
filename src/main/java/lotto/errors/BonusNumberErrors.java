package lotto.errors;

import java.util.List;

public class BonusNumberErrors {

    public void errorCheck(String bonusNumber, List<Integer> winningNumbers) {
        validateNumericBonusNumber(bonusNumber);
        Integer bonusNumberInt = Integer.parseInt(bonusNumber);
        validateBonusNumberRange(bonusNumberInt);
        validateBonusNumberUniqueness(bonusNumberInt, winningNumbers);
    }

    // 숫자 이외의 값을 입력했을 경우
    public void validateNumericBonusNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자만 입력해야 합니다.");
        }
    }

    // 45초과의 값을 입력했을 경우
    public void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    // 당첨번호와 중복된 보너스 번호 입력했을 경우
    public void validateBonusNumberUniqueness(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
