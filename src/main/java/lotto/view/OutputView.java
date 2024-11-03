package lotto.view;

public class OutputView {

    public void printPurchaseQuantity(int purchaseQuantity) {
        System.out.printf("%d개를 구매했습니다.\n", purchaseQuantity);
    }

    public void printWinningResult() {
        System.out.println("당첨 통계\n---");
    }

    public void printDetailResult(int matchNumberCount, int prizeMoney, int winningQuantity, boolean isBonusNumber) {
        if (!isBonusNumber) {
            System.out.printf("%d개 일치 (%,d원) - %d개\n", matchNumberCount, prizeMoney, winningQuantity);
        }
        if (isBonusNumber) {
            System.out.printf("%d개 일치, 보너스 볼 일치 (%,d원) - %d개\n", matchNumberCount, prizeMoney, winningQuantity);
        }
    }

    public void printRateOfReturn(int totalPrizeMoney, int purchaseMoney) {
        double rateOfReturn = (double) (totalPrizeMoney / purchaseMoney) * 100;
        System.out.printf("총 수익률은 %.1f%% 입니다.", rateOfReturn);
    }

}
