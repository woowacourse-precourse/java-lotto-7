package lotto.store.machine;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.stream.Collectors;
import lotto.store.user.Cash;
import lotto.store.user.Lotto;
import lotto.store.user.LottoTickets;
import lotto.store.winning.WinningLotto;
import lotto.store.winning.WinningRank;

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
        NumberFormat numberFormat = NumberFormat.getInstance();

        return Arrays.stream(WinningRank.values())
            .filter(rank -> !rank.equals(WinningRank.NOTHING))
            .map(rank -> resultFormat(rank, numberFormat))
            .collect(Collectors.joining());
    }

    private String resultFormat(WinningRank winningRank, NumberFormat numberFormat) {
        return String.format("%d%s (%s원) - %d개\n",
            winningRank.getMatchCount(),
            getMatchText(winningRank),
            numberFormat.format(winningRank.getPrizeAmount()),
            statistics.get(winningRank)
        );
    }

    private String getMatchText(WinningRank winningRank) {
        if (winningRank.equals(WinningRank.SECOND)) {
            return "개 일치, 보너스 볼 일치";
        }

        return "개 일치";
    }

}
