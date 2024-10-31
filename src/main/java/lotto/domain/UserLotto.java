package lotto.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class UserLotto {
    private List<Lotto> lottos;
    private Map<Integer,Integer> winningCount = new LinkedHashMap<>();

    public UserLotto(List<Lotto> lottos) {
        this.lottos = lottos;

        for(int i=1; i<=5; i++){
            winningCount.put(i,0);
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getWinningCount(int place){
        return winningCount.get(place);
    }

    public void updateWinningCount(int place){
        winningCount.put(place, winningCount.get(place)+1);
    }
}
