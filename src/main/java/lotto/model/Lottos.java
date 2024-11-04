package lotto.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public int getSize(){
        return lottos.size();
    }

    public Map<LottoRule, Integer> calculateMatch(List<Integer> winNumbers, int bonusNumber){
        Map<LottoRule, Integer> matchInfo = new HashMap<>();

        for (Lotto lotto : lottos) {
            int matchCount = 0;

            for (Integer winNumber : winNumbers) {
                if(lotto.getNumbers().contains(winNumber)){
                    matchCount++;
                }
            }

            boolean bonusMatch = (matchCount == 5) && lotto.getNumbers().contains(bonusNumber);
            LottoRule rule = LottoRule.getWinInfo(matchCount, bonusMatch);
            matchInfo.put(rule, matchInfo.getOrDefault(rule, 0) + 1);
        }
        return matchInfo;
    }
}

