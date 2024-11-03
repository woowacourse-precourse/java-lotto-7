package lotto.view;

import static lotto.constants.PrintMessage.LOTTO_PURCHASE_MESSAGE;
import static lotto.constants.PrintMessage.WINNING_STATISTICS_MESSAGE;

import java.util.EnumMap;
import java.util.List;
import java.util.Map.Entry;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;

public class ConsoleOutputView implements OutputView {

    @Override
    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void printPurchasedLottos(List<Lotto> purchasedLotto) {
        System.out.print("\n" + purchasedLotto.size());
        LOTTO_PURCHASE_MESSAGE.display();
        purchasedLotto.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    @Override
    public void printWinningStatistics(EnumMap<LottoRank, Integer> winningLottos) {
        WINNING_STATISTICS_MESSAGE.display();
        for (Entry<LottoRank, Integer> entry : winningLottos.entrySet()) {
            LottoRank rank = entry.getKey();
            Integer winningCount = entry.getValue();
            String winningMessage = getWinningMessage(rank, winningCount);
            System.out.println(winningMessage);
        }
    }

    @Override
    public void printTotalProfitRate(double profitRate) {
        System.out.println(getProfitRateMessage(profitRate));
    }

    private static String getProfitRateMessage(double profitRate) {
        String formattedProfitRate = String.format("%.1f", profitRate);
        return String.format("총 수익률은 %s%%입니다.", formattedProfitRate);
    }

    private String getWinningMessage(LottoRank rank, Integer winningCount) {
        int matchCount = rank.getMatchCount();
        String formattedReward = String.format("%,d", rank.getReward());
        if (rank == LottoRank.SECOND_PLACE) {
            return String.format("%d개 일치, 보너스 볼 일치 (%s원) - %d개", matchCount, formattedReward, winningCount);
        }
        return String.format("%d개 일치 (%s원) - %d개", matchCount, formattedReward, winningCount);
    }
}
