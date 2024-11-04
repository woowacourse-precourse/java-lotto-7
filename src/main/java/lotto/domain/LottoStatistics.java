package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoStatistics {
    private final static int ZERO = 0;

    private final Map<Prize, Integer> prizeMap = new EnumMap<>(Prize.class);

    private LottoStatistics(Map<Prize, Integer> prizeMap) {
        initPrizeMap();
        this.prizeMap.putAll(prizeMap);
    }

    public static LottoStatistics of(List<Lotto> lottoTicket, WinningLotto winningLotto) {
        return new LottoStatistics(getPrizeCountMap(lottoTicket, winningLotto));
    }

    private static Map<Prize, Integer> getPrizeCountMap(List<Lotto> lottoTicket, WinningLotto winningLotto) {
        Map<Prize, Integer> prizeCountMap = new EnumMap<>(Prize.class);

        for (Prize prize : Prize.values()) {
            prizeCountMap.put(prize, ZERO);
        }

        for (Lotto lotto : lottoTicket) {
            Prize prize = Prize.inspect(winningLotto, lotto);
            prizeCountMap.put(prize, prizeCountMap.get(prize) + 1);
        }
        return prizeCountMap;
    }

    private void initPrizeMap() {
        for (Prize prize : Prize.values()) {
            prizeMap.put(prize, ZERO);
        }
    }

}
