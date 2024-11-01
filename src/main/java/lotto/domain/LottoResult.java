package lotto.domain;

import java.util.List;
import java.util.Set;

public class LottoResult {
    private Lotto winningNumbers;
    private int bonusNumber;

    public LottoResult(List<Integer> resultNumbers, int bonusNumber) {
        resultNumbersValidate(resultNumbers);
        this.winningNumbers = new Lotto(resultNumbers);
        bonusNumberValidate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    void resultNumbersValidate(List<Integer> resultNumbers) {
    }

    private void bonusNumberValidate(int bonusNumber) {
        if (!(bonusNumber >= 1 && bonusNumber <= 45)) {
            throw new IllegalArgumentException("[ERROR] 보너스넘버는 1~45 사이의 정수여야 합니다.");
        }
        if (isLottoNumberDuplicated(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스넘버는 당첨 번호와 중복되어선 안됩니다.");
        }
    }

    private boolean isLottoNumberDuplicated(int bonusNumber) {
        Set<Integer> winningNumbersCopy = winningNumbers.getNumbers();
        return winningNumbersCopy.contains(bonusNumber);
    }

}
