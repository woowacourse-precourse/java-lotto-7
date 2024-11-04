package lotto.view.winningLottoView;

import lotto.util.NumberFormatter;

public class LottoProfitOutputView {

    private final NumberFormatter numberFormatter;

    public LottoProfitOutputView(NumberFormatter numberFormatter) {
        this.numberFormatter = numberFormatter;
    }

    public void showLottoProfitRate(double profitRate){
        System.out.println("총 수익률은 " + numberFormatter.formatNumber(profitRate) + "%입니다.");
    }

}
