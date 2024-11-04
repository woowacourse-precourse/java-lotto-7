package lotto.domain;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Stream;

public enum Winning {
    FIRST(5, 6, new BigInteger("2000000000"), Winning::isFirst),
    SECOND(4, 5, new BigInteger("30000000"), Winning::isSecond),
    THIRD(3, 5, new BigInteger("1500000"), Winning::isThird),
    FOURTH(2, 4, new BigInteger("50000"), Winning::isFourth),
    FIFTH(1, 3, new BigInteger("5000"), Winning::isFifth),
    NONE(0, 2, BigInteger.ZERO, Winning::isNone);

    private final int order;
    private final int condition;
    private final BigInteger prize;
    private final Function<Integer, Boolean> match;

    Winning(int order, int condition, BigInteger prize, Function<Integer, Boolean> match) {
        this.order = order;
        this.condition = condition;
        this.prize = prize;
        this.match = match;
    }

    public static Winning tellWinningBy(int targetCondition, Stream<Winning> winningStream) {
        return winningStream
                .map(winning -> {
                    if (winning.match.apply(targetCondition)) {
                        return winning;
                    }
                    return null;
                }).filter(Objects::nonNull)
                .findAny()
                .orElseThrow();
    }

    public static Winning tellWinningBy(int targetCondition, boolean includeSecond) {
        if (includeSecond) {
            return tellWinningBy(targetCondition, valuesAsStreamIncludeSecond());
        }
        return tellWinningBy(targetCondition, valuesAsStreamExceptSecond());
    }

    private static Stream<Winning> valuesAsStreamIncludeSecond() {
        return Arrays.stream(new Winning[]{SECOND, FOURTH, FIFTH, NONE});
    }

    private static Stream<Winning> valuesAsStreamExceptSecond() {
        return Arrays.stream(Winning.values())
                .filter(winning -> winning != SECOND);
    }

    public static Stream<Winning> valuesAsOrderedStream() {
        return Stream.of(Winning.values())
                .sorted(Comparator.comparingInt(winning -> winning.order))
                .filter(winning -> winning.order != 0);
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

    private static boolean isFirst(int condition) {
        return FIRST.condition == condition;
    }

    private static boolean isSecond(int condition) {
        return SECOND.condition == condition;
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

    public int getCondition() {
        return condition;
    }

    public BigInteger getPrize() {
        return prize;
    }
}
