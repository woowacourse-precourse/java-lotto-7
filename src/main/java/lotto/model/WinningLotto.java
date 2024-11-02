package lotto.model;

import lotto.dto.BonusNumberDto;
import lotto.dto.WinningLotteryDto;

public class WinningLotto {

    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public static WinningLotto from(WinningLotteryDto winningLotteryDto,
                                    BonusNumberDto bonusNumberDto) {
        return new WinningLotto(
                new Lotto(winningLotteryDto.winningLottery()),
                bonusNumberDto.bonusNumber()
        );
    }
}
