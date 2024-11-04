package lotto.week3.model;

import java.util.HashMap;
import java.util.Map;
import lotto.week3.dto.StatisticsRequestDto;

public class LottoStatistics {
    private static final int FIRST_PRIZE = 2000000000;
    private static final int SECOND_PRIZE = 30000000;
    private static final int THIRD_PRIZE = 1500000;
    private static final int FOURTH_PRIZE = 50000;
    private static final int FIFTH_PRIZE = 5000;

    private final Map<String , Integer> statisticsRequest;

    public LottoStatistics(){
        statisticsRequest = new HashMap<>();
        statisticsRequest.put("3개 일치", 0);
        statisticsRequest.put("4개 일치", 0);
        statisticsRequest.put("5개 일치", 0);
        statisticsRequest.put("5개 일치 + 보너스 일치", 0);
        statisticsRequest.put("6개 일치", 0);
    }

    public void calculatePrize(int matchCount, boolean bonusMatch){
        if (matchCount == 6){
            statisticsRequest.put("6개 일치", statisticsRequest.get("6개 일치") + 1);
        }else if (matchCount == 5 && bonusMatch) {
            statisticsRequest.put("5개 일치 + 보너스 일치", statisticsRequest.get("5개 일치 + 보너스 일치") + 1);
        }else if(matchCount == 5){
            statisticsRequest.put("5개 일치", statisticsRequest.get("5개 일치") +1);
        }else if (matchCount == 4){
            statisticsRequest.put("4개 일치", statisticsRequest.get("4개 일치") +1);
        } else if (matchCount == 3) {
            statisticsRequest.put("3개 일치", statisticsRequest.get("3개 일치") + 1);
        }
    }

    public int calculateTotalPrize() {
        return statisticsRequest.get("3개 일치") * FIFTH_PRIZE +
                statisticsRequest.get("4개 일치") * FOURTH_PRIZE +
                statisticsRequest.get("5개 일치") * THIRD_PRIZE +
                statisticsRequest.get("5개 일치 + 보너스 일치") * SECOND_PRIZE +
                statisticsRequest.get("6개 일치") * FIRST_PRIZE;
    }

    public StatisticsRequestDto getStatisticsRequestDto(){
        return new StatisticsRequestDto(statisticsRequest);
    }

}
