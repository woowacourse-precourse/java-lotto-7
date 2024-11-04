package lotto.view;

import lotto.util.NumberFormatterWithComma;
import lotto.util.NumberFormatterWithPercentage;
import lotto.view.lottoPurchaseView.LottoPurchaseOutputView;
import lotto.view.winningLottoView.LottoProfitOutputView;
import lotto.view.winningLottoView.WinningLottoOutputView;

public class LottoOutputViewFactory {

    public WinningLottoOutputView createWinningLottoOutputView() {
        return new WinningLottoOutputView(new NumberFormatterWithComma());
    }

    public LottoProfitOutputView createLottoProfitOutputView() {
        return new LottoProfitOutputView(new NumberFormatterWithPercentage());
    }

    public LottoPurchaseOutputView createLottoPurchaseOutputView(){
        return new LottoPurchaseOutputView();
    }
}
