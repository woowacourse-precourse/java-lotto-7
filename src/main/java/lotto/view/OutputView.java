package lotto.view;

import static lotto.model.PrizeTable.FIVE_BONUS_MATCHES;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.PrizeTable;

public class OutputView {

    public void printPurchaseQuantity(int purchaseMoney) {
        System.out.printf("\n%d개를 구매했습니다.\n", purchaseMoney / Lotto.PRICE);
    }

    public void printAllLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printWinningResult() {
        System.out.println("\n당첨 통계\n---");
    }

    public void printDetailResult() {
        StringBuilder result = new StringBuilder();
        for (PrizeTable prizeTable : PrizeTable.values()) {
            appendPrizeDetail(result, prizeTable);
        }
        System.out.println(result);
    }

    private void appendPrizeDetail(StringBuilder result, PrizeTable prizeTable) {
        int matchNumberCount = prizeTable.getMatchNumbers();
        int prizeMoney = prizeTable.getPrizeMoney();
        int winningQuantity = prizeTable.getWinningCount();

        if (prizeTable.equals(FIVE_BONUS_MATCHES)) {
            result.append(
                    String.format("%d개 일치, 보너스 볼 일치 (%,d원) - %d개%n", matchNumberCount, prizeMoney, winningQuantity));
        } else {
            result.append(String.format("%d개 일치 (%,d원) - %d개%n", matchNumberCount, prizeMoney, winningQuantity));
        }
    }

    public void printRateOfReturn(int totalPrizeMoney, int purchaseMoney) {
        double rateOfReturn = ((double) totalPrizeMoney / purchaseMoney) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.", rateOfReturn);
    }
}
