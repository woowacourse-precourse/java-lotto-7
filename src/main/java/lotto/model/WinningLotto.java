package lotto.model;

import lotto.dto.BonusNumberDto;
import lotto.dto.WinningLotteryDto;

import java.util.List;

public class WinningLotto {

    private final List<Integer> winningLotto;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningLotto() {
        return winningLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public static WinningLotto from(WinningLotteryDto winningLotteryDto,
                                    BonusNumberDto bonusNumberDto) {
        return new WinningLotto(
                winningLotteryDto.winningLottery(),
                bonusNumberDto.bonusNumber()
        );
    }
}
