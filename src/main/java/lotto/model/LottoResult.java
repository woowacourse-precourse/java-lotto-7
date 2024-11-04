package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private Map<Prize, Integer> lottoResult = new HashMap<>();

    public LottoResult(List<Integer> match_count, Integer bonus_match) {
        lottoResult.put(Prize.fifth, match_count.get(3));
        lottoResult.put(Prize.forth, match_count.get(4));
        lottoResult.put(Prize.third, match_count.get(5) - bonus_match);
        lottoResult.put(Prize.second, bonus_match);
        lottoResult.put(Prize.first, match_count.get(6));
    }
    
    public double calculateEarningsRate(int pay_amount) {
        double sum = 0;
        for (Map.Entry<Prize, Integer> entry: lottoResult.entrySet()) {
            sum += entry.getKey().prize * entry.getValue();
        }
        return sum / pay_amount * 100;
    }

    public Integer getValue(Prize prize) {
        return lottoResult.get(prize);
    }
}
