package lotto.view;

import java.text.DecimalFormat;

public class OutputView {
    public void printPurchaseResult(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public void printLottoResult(String result) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(result);
    }

    public void printWinningPercent(double percent) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.0");
        System.out.println("총 수익률은 " + decimalFormat.format(percent) + "%입니다.");
    }
}
