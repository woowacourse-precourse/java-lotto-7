package lotto.model;

import lotto.dto.BonusNumberDto;
import lotto.dto.WinningLotteryDto;

import static lotto.exception.LottoExceptionStatus.INVALID_BONUS_NUMBER_DUPLICATE_WITH_WINNING;

public class WinningLotto {

    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        isDuplicateWithWinningNumbers(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    private void isDuplicateWithWinningNumbers(Lotto winningLotto, int bonusNumber) {
        if (winningLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_DUPLICATE_WITH_WINNING.getMessage());
        }
    }

    public static WinningLotto from(WinningLotteryDto winningLotteryDto,
                                    BonusNumberDto bonusNumberDto) {
        return new WinningLotto(
                new Lotto(winningLotteryDto.winningLottery()),
                bonusNumberDto.bonusNumber()
        );
    }
}
