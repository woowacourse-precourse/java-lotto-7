package lotto.view;

import java.text.DecimalFormat;

public class OutputView {
    private OutputView() {}

    private static class Holder {
        private static final OutputView INSTANCE = new OutputView();
    }

    public static OutputView getInstance() {
        return OutputView.Holder.INSTANCE;
    }

    public void printProfitRate(double profitRate) {
        DecimalFormat profitRateFormat = new DecimalFormat("#,##0.0#%");
        System.out.println("총 수익률은 " + profitRateFormat.format(profitRate) + "입니다.");
    }
}
