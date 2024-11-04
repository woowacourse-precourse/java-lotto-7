package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoInspector {
    public static Map<Place, Integer> checkLottos(LottoBonus winner, List<Lotto> lottos) {
        Map<Place, Integer> map = new HashMap<>();
        for (Place place : Place.values()) {
            map.put(place, 0);
        }
        for (Lotto lotto : lottos) {
            Place place = checkLotto(winner, lotto);
            map.put(place, map.get(place) + 1);
        }
        return map;
    }

    private static Place checkLotto(LottoBonus winner, Lotto lotto) {
        int hitCount = 0;
        boolean hitBonus = false;
        Place result = Place.MISS;
        for (int number : lotto.getNumbers()) {
            if (winner.getLotto().getNumbers().contains(number)) {
                hitCount++;
            }
            if (winner.getBonus() == number) {
                hitBonus = true;
            }
        }
        for (Place place : Place.values()) {
            if (!(place.needHitBonusNumber && !hitBonus) & place.needHitCount == hitCount) {
                result = place;
            }
        }
        return result;
    }
}
