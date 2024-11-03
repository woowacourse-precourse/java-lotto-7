package lotto.domain;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.function.Function;

public enum Winning {
    FIRST(6, new BigInteger("2000000000"), Winning::isFirst),
    THIRD(5, new BigInteger("1500000"), Winning::isThird),
    FOURTH(4, new BigInteger("50000"), Winning::isFourth),
    FIFTH(3, new BigInteger("5000"), Winning::isFifth),
    NONE(2, BigInteger.ZERO, Winning::isNone);

    private final int condition;
    private final BigInteger prize;
    private final Function<Integer, Boolean> match;

    Winning(int condition, BigInteger prize, Function<Integer, Boolean> match) {
        this.condition = condition;
        this.prize = prize;
        this.match = match;
    }

    public static List<Winning> tellWinningBy(List<Integer> targetConditions) {
        List<Winning> winnings = new ArrayList<>();
        for (Integer targetCondition : targetConditions) {
            Winning winning = tellWinningBy(targetCondition);
            winnings.add(winning);
        }
        return winnings;
    }

    public static Winning tellWinningBy(int targetCondition) {
        return Arrays.stream(Winning.values())
                .map(winning -> {
                    if (winning.match.apply(targetCondition)) {
                        return winning;
                    }
                    return null;
                }).filter(Objects::nonNull)
                .findAny()
                .orElseThrow();
    }

    private static boolean isFirst(int condition) {
        return FIRST.condition == condition;
    }

    private static boolean isThird(int condition) {
        return THIRD.condition == condition;
    }

    private static boolean isFourth(int condition) {
        return FOURTH.condition == condition;
    }

    private static boolean isFifth(int condition) {
        return FIFTH.condition == condition;
    }

    private static boolean isNone(int condition) {
        return NONE.condition >= condition;
    }

    public static BigInteger tellTotalPrize(Map<Winning, Integer> winningCounts) {
        return winningCounts.entrySet().stream()
                .map(Winning::calculatePrizeOf)
                .reduce(BigInteger.ZERO, BigInteger::add);
    }

    private static BigInteger calculatePrizeOf(Entry<Winning, Integer> winningCount) {
        Winning winning = winningCount.getKey();
        BigInteger count = BigInteger.valueOf(winningCount.getValue());
        return winning.prize.multiply(count);
    }
}
