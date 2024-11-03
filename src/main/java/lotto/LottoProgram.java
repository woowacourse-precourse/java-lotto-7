package lotto;

import lotto.money.Money;
import lotto.store.LottoBuyer;
import lotto.store.LottoStore;
import lotto.store.lotto.*;
import lotto.ui.LottoResult;
import lotto.ui.WinningNumberSettings;

public class LottoProgram {
    private final LottoStore lottoStore;

    public LottoProgram(LottoStore lottoStore) {
        this.lottoStore = lottoStore;
    }

    public LottoResult start(final Money seedMoney, final WinningNumberSettings settings) {
        LottoBuyer lottoBuyer = new LottoBuyer(lottoStore, seedMoney);
        WinningNumbers winningNumbers = setWinningNumbers(settings);

        return new LottoResult(
                lottoBuyer.result(winningNumbers),
                lottoBuyer.rateOfReturn(winningNumbers)
        );
    }

    private static WinningNumbers setWinningNumbers(WinningNumberSettings settings) {
        return new WinningNumbers(
                LottoGenerator.manual(settings.getWinningNumber()),
                new LottoNumber(settings.getBonusNumber())
        );
    }

}
