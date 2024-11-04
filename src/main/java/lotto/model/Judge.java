package lotto.model;

import java.util.List;
import java.util.function.Predicate;
import lotto.util.Grade;

public class Judge {
    private final List<Lotto> lottos;
    private final Lotto winning;
    private final int bonus;

    private Judge(List<Lotto> lottos, Lotto winning, int bonus) {
        this.lottos = lottos;
        this.winning = winning;
        this.bonus = bonus;
    }

    public static Judge from(List<Lotto> lottos, Lotto winning, int bonus) {
        return new Judge(lottos, winning, bonus);
    }

    public Grade assignGrade(int matchCount, boolean bonusMatching) {
        if(matchCount == 6) {
            return Grade.FIRST;
        }
        if(bonusMatching && matchCount == 5) {
            return Grade.SECOND;
        }
        if(!bonusMatching && matchCount == 5) {
            return Grade.THIRD;
        }
        if(matchCount == 4) {
            return Grade.FORTH;
        }
        if(matchCount == 3) {
            return Grade.FIFTH;
        }
        if(matchCount >= 0) {
            return null;
        }
        throw new IllegalArgumentException("[ERROR] 유효하지 않은 matchCount입니다.");
    }

    public int countMatchingDigits(Lotto compareLotto) {
        return compareLotto.getNumbers().stream()
                .filter(num -> winning.getNumbers().stream()
                        .anyMatch(Predicate.isEqual(num)))
                .toList()
                .size();
    }

    public boolean isBonusNumInclude() {
        return winning.getNumbers().contains(bonus);
    }
}
