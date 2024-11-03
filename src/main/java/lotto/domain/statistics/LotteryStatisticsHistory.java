package lotto.domain.statistics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LotteryRoundStatistics {
    private final Map<Long, List<Statistics>> roundStatistics;

    private LotteryRoundStatistics() {
        this.roundStatistics = new HashMap<>();
    }

    public LotteryRoundStatistics initInstance(List<LottoDrawStatistics> lottoDrawStatistics) {
        return new LotteryRoundStatistics();
    }

    public List<Statistics> getStatistics(Long round){
        return new ArrayList<>(roundStatistics.getOrDefault(round, new ArrayList<>()));
    }

    public void addRound(Long round,List<Statistics> statistics){


    }
}
