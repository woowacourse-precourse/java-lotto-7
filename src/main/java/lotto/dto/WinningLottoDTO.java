package lotto.dto;

import static lotto.util.validator.LottoNumberValidator.validateDuplicated;

import java.util.List;
import lotto.model.Lotto;

public class WinningLottoDTO {

    private final Lotto winningLotto;
    private final Integer bonusNumber;

    public WinningLottoDTO(Lotto winningLotto, Integer bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = validateDuplicated(winningLotto, bonusNumber);
    }

    public List<Integer> getWinningNumber() {
        return winningLotto.getNumbers();
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
