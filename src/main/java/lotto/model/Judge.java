package lotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import lotto.util.Grade;

public class Judge {
    private final List<Lotto> lottos;
    private final Lotto winning;
    private final Integer bonus;

    private Judge(List<Lotto> lottos, Lotto winning, Integer bonus) {
        this.lottos = lottos;
        this.winning = winning;
        this.bonus = bonus;
    }

    public static Judge from(List<Lotto> lottos, Lotto winning, Integer bonus) {
        return new Judge(lottos, winning, bonus);
    }

    public EnumMap<Grade, Integer> allJudgedGrade() {
        EnumMap<Grade, Integer> result = lottos.stream()
                .map(this::judgeGrade)
                .filter(Objects::nonNull)
                .collect(groupByGrade());
        populateMissingGrades(result);
        return result;
    }

    private void populateMissingGrades(EnumMap<Grade, Integer> result) {
        for (Grade grade : Grade.values()) {
            result.putIfAbsent(grade, 0);
        }
    }

    private Collector<Grade, ?, EnumMap<Grade, Integer>> groupByGrade() {
        return Collectors.groupingBy(
                grade -> grade,
                () -> new EnumMap<>(Grade.class),
                Collectors.collectingAndThen(Collectors.counting(), Long::intValue)
        );
    }

    private Grade judgeGrade(Lotto lotto) {
        int matchCount = countMatchingDigits(lotto);
        boolean bonusMaching = isBonusNumInclude(lotto);
        return assignGrade(matchCount, bonusMaching);
    }

    public Grade assignGrade(int matchCount, boolean bonusMatching) {
        if (matchCount == 6) {
            return Grade.FIRST;
        }
        if (bonusMatching && matchCount == 4) {
            return Grade.SECOND;
        }
        if (!bonusMatching && matchCount == 5) {
            return Grade.THIRD;
        }
        if (matchCount == 4) {
            return Grade.FORTH;
        }
        if (matchCount == 3) {
            return Grade.FIFTH;
        }
        if (matchCount >= 0) {
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

    public boolean isBonusNumInclude(Lotto lotto) {
        return lotto.getNumbers().contains(bonus);
    }
}
