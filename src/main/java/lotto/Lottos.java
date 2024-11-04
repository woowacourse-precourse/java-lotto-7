package lotto;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos generateLottosByCount(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(Lotto.generateLottoTicket());
        }
        return new Lottos(lottos);
    }

    public WinningStatisticsDto calculateWinningResults(WinningLotto winningLotto) {
        Map<Rank, Integer> winningStatistics = new EnumMap<>(Rank.class);
        for (Lotto lotto : lottos) {
            int matchCount = lotto.getMatchCount(winningLotto);
            boolean isBonusMatched = lotto.isBonusNumberMatched(winningLotto);

            Rank rank = Rank.getRank(matchCount, isBonusMatched);
            winningStatistics.put(rank, winningStatistics.getOrDefault(rank, 0) + 1);
        }
        return new WinningStatisticsDto(winningStatistics);
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
    }
}
