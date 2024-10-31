package lotto.dto;

import static lotto.util.validator.LottoNumberValidator.validateDuplicated;

import java.util.List;
import lotto.model.Lotto;

public class WinningLottoDTO {

    private final Lotto winningNumbers;
    private final Integer bonusNumber;

    public WinningLottoDTO(Lotto winningNumbers, Integer bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = validateDuplicated(winningNumbers, bonusNumber);
    }

    public List<Integer> getWinningNumber() {
        return winningNumbers.getNumbers();
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
