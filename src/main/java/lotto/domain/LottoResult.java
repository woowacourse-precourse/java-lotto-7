package lotto.domain;

import java.util.List;
import lotto.common.LottoConfig;
import lotto.common.validator.LottoResultValidator;

public class LottoResult {
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public LottoResult(List<Integer> resultNumbers, int bonusNumber) {
        this.winningNumbers = new Lotto(resultNumbers);
        LottoResultValidator.bonusNumberValidate(bonusNumber, List.copyOf(winningNumbers.getNumbers()));
        this.bonusNumber = bonusNumber;
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
