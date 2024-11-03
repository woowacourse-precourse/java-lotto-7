package lotto.model;

import java.util.List;

import static lotto.constant.ErrorMessage.BONUS_NUMBER_DUPLICATE_WITH_WINNING_ERROR_MESSAGE;

public class WinningLotto {
    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;

    public WinningLotto(Lotto winningLotto, BonusNumber bonusNumber) {
        validationWinningLottoNumbersDuplication(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validationWinningLottoNumbersDuplication(Lotto winningLotto, BonusNumber bonusNumber) {
        if(winningLotto.getNumbers().contains(bonusNumber.getBonusNumber())){
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE_WITH_WINNING_ERROR_MESSAGE);
        }
    }

    public List<Integer> getWinningLotto() {
        return winningLotto.getNumbers();
    }

    public Integer getBonusNumber() {
        return bonusNumber.getBonusNumber();
    }
}
