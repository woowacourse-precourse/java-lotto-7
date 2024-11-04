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
    public static LotteryStatisticsHistory initInstance() {
        return new LotteryStatisticsHistory();
    }

    public List<Statistics> getStatistics(Long round){
        return new ArrayList<>(lotteryStatisticsHistory.getOrDefault(round, new ArrayList<>()));
    }

    public void addLotteryStatisticsHistory(Long round,List<Statistics> statistics){
        lotteryStatisticsHistory.put(round, List.copyOf(statistics));
    }

    public Long getSize(){
        return Long.parseLong(String.valueOf(lotteryStatisticsHistory.size()));
    }


}
