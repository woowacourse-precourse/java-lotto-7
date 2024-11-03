package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    public Map<Rank,Integer> getFinalResult(List<Lotto> lottoTickets, List<Integer> winningNumbers, int bonus){
        Map<Rank,Integer> result = new HashMap<>();
        for (Lotto lotto : lottoTickets){
            Rank rank = lotto.getResult(winningNumbers,bonus);
            result.put(rank,result.getOrDefault(rank,0)+1);
        }
        return result;
    }

}
