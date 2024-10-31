package lotto.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class UserLotto {
    private final List<Lotto> lotteries;
    private Map<Integer,Integer> winningCount = new LinkedHashMap<>();

    public UserLotto(List<Lotto> lotteries) {
        this.lotteries = lotteries;

        for(int i=1; i<=5; i++){
            winningCount.put(i,0);
        }
    }

    public List<Lotto> getLotteries() {
        return lotteries;
    }

    public int getWinningCount(int place){
        return winningCount.get(place);
    }

    public void updateWinningCount(int place){
        winningCount.put(place, winningCount.get(place)+1);
    }
}
