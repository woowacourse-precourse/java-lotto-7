package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    public Map<Rank,Integer> getFinalResult(List<Lotto> lottoTickets, List<Integer> winningNumbers, int bonus){
        Map<Rank,Integer> result = new HashMap<>();
        for(Rank rank : Rank.values()){
            result.put(rank,0);
        }
        for (Lotto lotto : lottoTickets){
            Rank rank = lotto.getResult(winningNumbers,bonus);
            result.put(rank,result.get(rank)+1);
        }
        return result;
    }
    public float getRateOfReturn(Map<Rank,Integer> result,int budget){
        float profit = 0;
        for (Rank rank : Rank.values()){
            profit+=rank.getPrize()*result.get(rank);
        }
        return profit/budget*100;
    }

}
