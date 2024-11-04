package lotto.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.utils.ConstantValue;
import lotto.utils.LottoPrize;

public class LottoService {
    public List<Lotto> getSeveralLotto(int amount) {
        List<Lotto> severalLotto = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            severalLotto.add(Lotto.pickLotto());
        }
        return severalLotto;
    }

    public Map<String, Integer> countPrize(List<Lotto> lottoBundle, List<Integer> winningNumbers, int bonus) {
        Map<String, Integer> countMap = new HashMap<>();
        for (LottoPrize lottoPrize : LottoPrize.values()) {
            countMap.put(lottoPrize.name(), (int) lottoBundle.stream()
                    .filter(lotto -> lottoPrize.isMatchCondition(
                            lotto.countMatch(winningNumbers),
                            lotto.hasBonus(bonus)
                    ))
                    .count()
            );
        }
        return countMap;
    }

    public float getReturnRate(Map<String, Integer> countMap, int price) {
        long returnSum = 0;
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            returnSum += (long) LottoPrize.valueOf(entry.getKey()).getReward() * entry.getValue();
        }
        return (float) returnSum / price * ConstantValue.PERCENTAGE_RATE;
    }
}
