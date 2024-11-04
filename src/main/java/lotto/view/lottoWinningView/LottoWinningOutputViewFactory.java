package lotto.view.lottoWinningView;

import lotto.util.NumberFormatterWithComma;
import lotto.util.NumberFormatterWithPercentage;

public class LottoWinningOutputViewFactory {

    public WinningLottoOutputView createWinningLottoOutputView() {
        return new WinningLottoOutputView(new NumberFormatterWithComma());
    }

    public LottoProfitOutputView createLottoProfitOutputView() {
        return new LottoProfitOutputView(new NumberFormatterWithPercentage());
    }
}
