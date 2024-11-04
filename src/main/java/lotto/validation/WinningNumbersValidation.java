package lotto.validation;

import java.util.List;

public class WinningNumbersValidation {

    public void checkRange(int input) {
        if (input < 1 || input > 45) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public void checkDuplicateNumber(List<Integer> winningLotto, int bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨번호와 중복되었습니다.");
        }
    }

}
