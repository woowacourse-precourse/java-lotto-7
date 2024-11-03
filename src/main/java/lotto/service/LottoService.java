package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.MatchLevel;

public class LottoService {

    public List<Lotto> generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            numbers.sort(Comparator.naturalOrder());

            lottos.add(new Lotto(numbers));
        }

        return lottos;
    }

    public Map<MatchLevel, Integer> caculateMatchLevel(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        Map<MatchLevel, Integer> result = new EnumMap<>(MatchLevel.class);

        for (MatchLevel level : MatchLevel.values()) {
            result.put(level, 0);
        }

        for (Lotto lotto : lottos) {
            int matchCount = lotto.countMatchingNumbers(winningNumbers);

            boolean bonusMatched = lotto.isMatchingBonusNumber(bonusNumber);
            MatchLevel level = MatchLevel.getMatchLevel(matchCount, bonusMatched);

            result.put(level, result.get(level) + 1);
        }

        return result;
    }

    public double calculateProfit(Map<MatchLevel, Integer> result , long purchaseAmount) {
        long totalPrize = result.entrySet().stream()
                    .mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
                    .sum();

        return (double) totalPrize / purchaseAmount * 100;
    }

}
