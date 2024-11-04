package lotto.lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.lotto.providable.NumbersProvidable;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos from(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public static Lottos of(int numOfLottos, NumbersProvidable numbersProvidable) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < numOfLottos; i++) {
            lottos.add(Lotto.create(numbersProvidable));
        }

        return new Lottos(lottos);
    }

    public List<MatchingCondition> convertLottosToMatchedConditions(List<Integer> numbers, BonusNumber bonusNumber) {
        List<MatchingCondition> conditions = new ArrayList<>();

        for (Lotto lotto : lottos) {
            int matchingCount = lotto.calculateMatchingCount(numbers);
            boolean doesBonusMatched = lotto.hasNumber(bonusNumber.getBonusNumber());
            MatchingCondition matchingCondition = MatchingCondition.findByMatchingResult(matchingCount,
                    doesBonusMatched);

            conditions.add(matchingCondition);
        }

        return conditions;
    }
}
