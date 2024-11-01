package lotto.model.lottowinningstrategy;

import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.WinningNumbers;

public interface WinningStrategy {

    LottoRank calculateRank(Lotto lotto, WinningNumbers winningNumbers);
}
