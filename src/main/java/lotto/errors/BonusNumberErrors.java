package lotto.errors;

import java.util.List;

public class BonusNumberErrors {

    public void errorCheck(int bonusNumber, List<Integer> winningNumbers) {
        validateBonusNumberRange(bonusNumber);
        validateBonusNumberUniqueness(bonusNumber, winningNumbers);
        validateNumericBonusNumber(String.valueOf(bonusNumber));
    }

    // 45초과의 값을 입력했을 경우
    public void validateBonusNumberRange(int bonusNumber) {

    }
    // 당첨번호와 중복된 보너스 번호 입력했을 경우
    public void validateBonusNumberUniqueness(int bonusNumber, List<Integer> winningNumbers) {

    }
    // 숫자 이외의 값을 입력했을 경우
    public void validateNumericBonusNumber(String input) {

    }
}
