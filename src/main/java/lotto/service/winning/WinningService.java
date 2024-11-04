package lotto.service.winning;

import lotto.domain.LottoPurchase;
import lotto.domain.winning.BonusNumber;
import lotto.domain.winning.Winning;
import lotto.domain.winning.WinningNumbers;

public interface WinningService {

    Winning createWinning(WinningNumbers winningNumbers, BonusNumber bonusNumber);

    LottoStatistics estimate(LottoPurchase purchase, Winning winning);
}
