package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MatchLotto {
    private HashMap<Integer, Integer> initializeMatchLotto() {
        HashMap<Integer, Integer> result = new HashMap<>();
        result.put(5000, 0);
        result.put(50000, 0);
        result.put(1500000, 0);
        result.put(30000000, 0);
        result.put(2000000000, 0);
        return result;
    }

    public HashMap<Integer, Integer> MatchLotto(BuyLotto dataUserLotto, Lotto lotto, AdditionalNumber additional){
        HashMap<Integer, Integer> result = initializeMatchLotto();
        for (List<Integer> data : dataUserLotto.getDataUserLotto()) {
            if (matchEachLotto(lotto.getLottoValue(), data) == 3) {
                result.put(5000, result.get(5000) + 1);
            }
            if (matchEachLotto(lotto.getLottoValue(), data) == 4) {
                result.put(50000, result.get(50000) + 1);
            }
            if ((matchEachLotto(lotto.getLottoValue(), data) == 5) && (!data.contains(additional.getNumber()))) {
                result.put(1500000, result.get(1500000) + 1);
            }
            if ((matchEachLotto(lotto.getLottoValue(), data) == 5) && (data.contains(additional.getNumber()))) {
                result.put(30000000, result.get(30000000) + 1);
            }
            if ((matchEachLotto(lotto.getLottoValue(), data) == 6)) {
                result.put(2000000000, result.get(2000000000) + 1);
            }
        }
            return result;
    }
    public int matchEachLotto(List<Integer> realLotto, List<Integer> userLotto){int count = 0;
        for (int i : realLotto) {
            if (userLotto.contains(i)) {
                count++;
            }
        }
        return count;
    }
}