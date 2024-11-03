package lotto.view.output;

import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.LottoTicket;

public class OutputView {

    public void outputLottoNumbers(LottoTicket lottoTicket) {
        System.out.println("\n" + lottoTicket.getLottos().size() + OutputViewMessage.PURCHASE_COUNT_VIEW);
        for (Lotto lotto : lottoTicket.getLottos()) {
            String numbers = lotto.getNumbers().stream()
                    .sorted()
                    .map(String::valueOf)
                    .reduce((num1, num2) -> num1 + ", " + num2)
                    .orElse("");

            System.out.println("[" + numbers + "]");
        }
    }

    public void outputRankSummary(Map<LottoRank, Integer> resultRank, double profitRate) {
        System.out.println(OutputViewMessage.SUMMARY_VIEW);
        for (LottoRank rank : LottoRank.values()) {
            if (rank == LottoRank.NONE) {
                continue;
            }
            int count = resultRank.getOrDefault(rank, 0);
            printRank(rank, count);
        }
        printProfitRate(profitRate);
    }

    private void printRank(LottoRank rank, int count) {
        String bonusText = "";
        if (rank.getRequireBonus()) {
            bonusText = OutputViewMessage.BONUS_MATCH;
        }
        System.out.printf(OutputViewMessage.MATCH_COUNT + bonusText + OutputViewMessage.PRIZE_AMOUNT + "\n",
                rank.getMatchingNumberCount(),
                String.format("%,d", rank.getMoney()),
                count);
    }

    private void printProfitRate(double profitRate) {
        System.out.printf(OutputViewMessage.PROFIT_RATE + "\n", profitRate);
    }

}
