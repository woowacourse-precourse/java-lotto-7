package lotto;

import java.text.NumberFormat;
import java.util.EnumMap;

public class StatisticalMachine {

    private final EnumMap<WinningRank, Integer> statistics;

    public StatisticalMachine() {
        int defaultCount = 0;
        statistics = new EnumMap<>(WinningRank.class);

        for (WinningRank rank : WinningRank.values()) {
            statistics.put(rank, defaultCount);
        }
    }

    public void calculate(LottoTickets lottoTickets, WinningLotto winningLotto) {
        for (Lotto lotto : lottoTickets.getLottos()) {
            int matchCount = winningLotto.matchCount(lotto);
            boolean matchBonus = winningLotto.matchBonus(matchCount, lotto);

            WinningRank winningRank = WinningRank.getWinningRank(matchCount, matchBonus);

            statistics.put(winningRank, statistics.get(winningRank) + 1);
        }
    }

    public double getTotalProfit(Cash cash) {
        int sum = 0;
        for (WinningRank winningRank : WinningRank.values()) {
            sum += winningRank.calculatePrize(statistics.get(winningRank));
        }

        double profit = ((double) sum / cash.getAmount()) * 100;

        return Math.round(profit * 10) / 10.0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        NumberFormat numberFormat = NumberFormat.getInstance();

        for (WinningRank winningRank : WinningRank.values()) {
            if (winningRank.equals(WinningRank.NOTHING)) {
                continue;
            }

            sb.append(resultFormat(winningRank, numberFormat));
        }

        return sb.toString();
    }

    private String resultFormat(WinningRank winningRank, NumberFormat numberFormat) {
        if (winningRank.equals(WinningRank.SECOND)) {
            return String.format("%s개 일치, 보너스 볼 일치 (%s원) - %s개\n",
                winningRank.getMatchCount(),
                numberFormat.format(winningRank.getPrizeAmount()),
                statistics.get(winningRank)
            );
        }

        return String.format("%s개 일치 (%s원) - %s개\n",
            winningRank.getMatchCount(),
            numberFormat.format(winningRank.getPrizeAmount()),
            statistics.get(winningRank)
        );
    }

}
