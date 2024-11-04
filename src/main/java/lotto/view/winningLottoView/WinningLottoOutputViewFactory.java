package lotto.view.winningLottoView;

import lotto.util.NumberFormatterWithComma;
import lotto.util.NumberFormatterWithPercentage;

public class WinningLottoOutputViewFactory {

    public WinningLottoOutputView createWinningLottoOutputView() {
        return new WinningLottoOutputView(new NumberFormatterWithComma());
    }

    public LottoProfitOutputView createLottoProfitOutputView() {
        return new LottoProfitOutputView(new NumberFormatterWithPercentage());
    }
}
