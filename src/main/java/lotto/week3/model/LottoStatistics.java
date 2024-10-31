package lotto.week3.model;

import java.util.HashMap;
import java.util.Map;

public class LottoStatistics {
    private static final int FIRST_PRIZE = 2000000000;
    private static final int SECOND_PRIZE = 30000000;
    private static final int THIRD_PRIZE = 1500000;
    private static final int FOURTH_PRIZE = 50000;
    private static final int FIFTH_PRIZE = 5000;

    private final Map<String , Integer> resultMap = new HashMap<>();

    public LottoStatistics(){
        resultMap.put("3개 맞춤", 0);
        resultMap.put("4개 맞춤", 0);
        resultMap.put("5개 맞춤", 0);
        resultMap.put("5개 맞춤 + 보너스 맞춤", 0);
        resultMap.put("6개 맞춤", 0);
    }

    public void calculatePrize(int matchCount, boolean bonusMatch){
        if (matchCount == 6){
            resultMap.put("6개 맞춤", resultMap.get("6개 맞춤") + 1);
        }else if (matchCount == 5 && bonusMatch) {
            resultMap.put("5개 맞춤 + 보너스 맞춤", resultMap.get("5개 맞춤 + 보너스 맞춤") + 1);
        }else if(matchCount == 5){
            resultMap.put("5개 맞춤", resultMap.get("5개 맞춤") +1);
        }else if (matchCount == 4){
            resultMap.put("4개 맟줌", resultMap.get("4개 맞춤") +1);
        } else if (matchCount == 3) {
            resultMap.put("5개 맞춤", resultMap.get("5개 맞춤") + 1);
        }
    }

    public int calculateTotalPrize() {
        return resultMap.get("3개 일치") * FIFTH_PRIZE +
                resultMap.get("4개 일치") * FOURTH_PRIZE +
                resultMap.get("5개 일치") * THIRD_PRIZE +
                resultMap.get("5개 일치 + 보너스") * SECOND_PRIZE +
                resultMap.get("6개 일치") * FIRST_PRIZE;
    }
}
