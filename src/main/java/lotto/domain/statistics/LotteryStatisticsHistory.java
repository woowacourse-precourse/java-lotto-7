package lotto.domain.statistics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LotteryStatisticsHistory {
    private final Map<Long, List<Statistics>> lotteryStatisticsHistory;

    private LotteryStatisticsHistory() {
        this.lotteryStatisticsHistory = new HashMap<>();
    }

    public LotteryStatisticsHistory initInstance(List<LottoDrawStatistics> lottoDrawStatistics) {
        return new LotteryStatisticsHistory();
    }

    public List<Statistics> getStatistics(Long round){
        return new ArrayList<>(lotteryStatisticsHistory.getOrDefault(round, new ArrayList<>()));
    }

    public void addLotteryStatisticsHistory(Long round,List<Statistics> statistics){
        lotteryStatisticsHistory.put(round, List.copyOf(statistics));
    }
}
