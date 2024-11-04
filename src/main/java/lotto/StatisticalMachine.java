package lotto;

import java.util.EnumMap;

public class StatisticalMachine {

    private final EnumMap<WinningRank, Integer> statistics;

    public StatisticalMachine() {
        statistics = new EnumMap<>(WinningRank.class);

        for (WinningRank rank : WinningRank.values()) {
            statistics.put(rank, 0);
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

}
