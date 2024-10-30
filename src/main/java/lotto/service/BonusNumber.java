package lotto.service;

import java.util.List;

public class BonusNumber {
    private final Integer bonus;
    private final WinningNumber winningNumber;

    public BonusNumber(Integer bonus, WinningNumber winningNumber) {
        this.bonus = bonus;
        this.winningNumber = winningNumber;
        validateBonus();
    }

    private void validateBonus() {
        validateNull(bonus);
        validateRange(bonus);
        validateNoDuplicateWithWinningNumbers(bonus,winningNumber.getNumbers());
    }

    private void validateNoDuplicateWithWinningNumbers(Integer bonus, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    private void validateRange(Integer bonus) {
        if(bonus <1|| bonus >45){
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 범위를 벗어납니다.");
        }
    }

    private void validateNull(Integer bonus) {
        if(bonus ==null){
            throw new IllegalArgumentException("[ERROR] 보너스 번호를 입력해주세요");
        }
    }

    public Integer getBonus() {
        return bonus;
    }
}
