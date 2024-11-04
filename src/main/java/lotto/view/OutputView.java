package lotto.view;

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
        System.out.println("총 수익률은 " + percent + "%입니다.");
    }
}
