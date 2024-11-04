package lotto;

public class OutputView {

    public void printLottoPurchaseDetails(Lottos lottos) {
        System.out.println();
        System.out.printf("%d개를 구매했습니다.\n", lottos.getCount());
        System.out.printf("%s\n", lottos.toString());
    }

    public void printStatistics(LottoResult lottoResult, int purchaseAmount) {
        System.out.println();
        System.out.println("당첨 통계\n---");
        System.out.println(lottoResult.getWinningStatistics());
        System.out.println(String.format("총 수익률은 %.1f%%입니다.",
                lottoResult.calculateProfitRate(purchaseAmount)));
    }

}
