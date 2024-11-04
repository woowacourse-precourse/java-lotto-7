package lotto.view;


public class OutputView {
    public static void showPurchasedLottosQuantity(int quantity) {
        System.out.println("\n" + quantity + "개를 구매했습니다.");
    }

    public static void showPurchasedLottos(String purchasedLottos) {
        System.out.println(purchasedLottos);
    }

    public static void announceWinningStatistics(String winningStatistics, double lottoYield){
        System.out.println("\n당첨통계");
        System.out.println("---");
        System.out.print(winningStatistics);
        System.out.println("총 수익률은 " + lottoYield + "%입니다.");
        System.out.println("---");
    }
}
