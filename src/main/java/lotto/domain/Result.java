package lotto.domain;

import lotto.constant.Reward;
import lotto.message.InfoMessage;

import java.util.Arrays;
import java.util.function.BiPredicate;

import static lotto.constant.LottoValues.*;
import static lotto.constant.Reward.*;
import static lotto.message.InfoMessage.*;

public enum Result {

    NO_PROFIT(false, null, NO_REWARD,
            (match, bonus) -> THREE.isGreaterThan(match)),

    THREE_RESULT(true, THREE_NUMBERS_MATCH, THREE_REWARD,
            (match, bonus) -> THREE.isEqualTo(match)),

    FOUR_RESULT(true, FOUR_NUMBERS_MATCH, FOUR_REWARD,
            (match, bonus) -> FOUR.isEqualTo(match)),

    FIVE_RESULT(true, FIVE_NUMBERS_MATCH, FIVE_REWARD,
            (match, bonus) -> FIVE.isEqualTo(match) && !bonus),

    FIVE_WITH_BONUS_RESULT(true, FIVE_NUMBERS_MATCH_WITH_BONUS, FIVE_WITH_BONUS_REWARD,
            (match, bonus) -> FIVE.isEqualTo(match) && bonus),

    SIX_RESULT(true, SIX_NUMBERS_MATCH, SIX_REWARD,
            (match, bonus) -> SIX.isEqualTo(match));

    public final boolean print;
    private final InfoMessage infoMessage;
    private int resultCount;
    private final Reward reward;
    private final BiPredicate<Integer, Boolean> predicate;

    Result(boolean print, InfoMessage infoMessage, Reward reward, BiPredicate<Integer, Boolean> predicate) {
        this.print = print;
        this.infoMessage = infoMessage;
        this.resultCount = 0;
        this.reward = reward;
        this.predicate = predicate;
    }

    private void increment() {
        resultCount++;
    }

    private boolean equals(int matchingNumber, boolean bonus) {
        return predicate.test(matchingNumber, bonus);
    }

    public static Result find(int matchingNumber, boolean bonus) {
        return Arrays.stream(Result.values())
                .filter(result -> result.equals(matchingNumber, bonus))
                .findAny()
                .orElse(NO_PROFIT);
    }

    public static void updateResult(int matchingNumber, boolean bonus) {
        find(matchingNumber, bonus).increment();
    }

    public static long calculateProfitSum() {
        return Arrays.stream(Result.values())
                .mapToLong(Result::calculateProfit)
                .sum();
    }

    private long calculateProfit() {
        return resultCount * reward.value();
    }

    public static int getResultCount(int matchingNumber, boolean bonus) {
        return find(matchingNumber, bonus).resultCount;
    }

    public String formattedMessage() {
        return infoMessage.formatNumber(resultCount);
    }
}
