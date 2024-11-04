package lotto;

import lotto.money.Money;
import lotto.store.LottoBuyer;
import lotto.store.LottoStore;
import lotto.store.lotto.*;
import lotto.store.lotto.winner.WinningNumbers;
import lotto.ui.LottoResult;
import lotto.ui.UserSettingReader;
import lotto.ui.WinningNumberSettings;

public class LottoProgram {
    private final LottoStore lottoStore;
    private final UserSettingReader setting;

    public LottoProgram(LottoStore lottoStore, UserSettingReader userSettingReader) {
        this.lottoStore = lottoStore;
        setting = userSettingReader;
    }

    public LottoResult start() {
        final Money seedMoney = new Money(setting.readSeedMoney());
        final WinningNumberSettings settings = setting.readWinningNumbers();

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
