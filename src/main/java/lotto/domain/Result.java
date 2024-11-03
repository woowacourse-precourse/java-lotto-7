package lotto.domain;

import lotto.message.InfoMessage;

import java.util.Arrays;
import java.util.function.BiPredicate;

import static lotto.constant.LottoValues.*;
import static lotto.message.InfoMessage.*;

public enum Result {

    NO_PROFIT(false, null, 0,
            (match, bonus) -> match < THREE.value()),

    THREE_RESULT(true, THREE_NUMBERS_MATCH, 5_000,
            (match, bonus) -> match == THREE.value()),

    FOUR_RESULT(true, FOUR_NUMBERS_MATCH, 50_000,
            (match, bonus) -> match == FOUR.value()),

    FIVE_RESULT(true, FIVE_NUMBERS_MATCH, 1_500_000,
            (match, bonus) -> match == FIVE.value() && !bonus),

    FIVE_WITH_BONUS_RESULT(true, FIVE_NUMBERS_MATCH_WITH_BONUS, 30_000_000,
            (match, bonus) -> match == FIVE.value() && bonus),

    SIX_RESULT(true, SIX_NUMBERS_MATCH, 2_000_000_000,
            (match, bonus) -> match == SIX.value());

    public boolean print;
    private InfoMessage infoMessage;
    private int result;
    private long amount;
    private BiPredicate<Integer, Boolean> predicate;

    Result(boolean print, InfoMessage infoMessage, long amount, BiPredicate<Integer, Boolean> predicate) {
        this.print = print;
        this.infoMessage = infoMessage;
        this.result = 0;
        this.amount = amount;
        this.predicate = predicate;
    }

    private void increment() {
        result++;
    }

    private boolean equals(int matchingNumber, boolean bonus){
        return predicate.test(matchingNumber, bonus);
    }

    public static Result matches(int matchingNumber, boolean bonus) {
        return Arrays.stream(Result.values())
                .filter(result -> result.equals(matchingNumber, bonus))
                .findAny()
                .orElse(NO_PROFIT);
    }

    public static void update(int matchingNumber, boolean bonus) {
        matches(matchingNumber, bonus).increment();
    }

    public static int getResult(int matchingNumber, boolean bonus) {
        return matches(matchingNumber, bonus).result;
    }

    public String getMessage(){
        return infoMessage.formatNumber(result);
    }

    public static long getProfitSum() {
        return Arrays.stream(Result.values())
                .mapToLong(Result::calculateProfit)
                .sum();
    }

    private long calculateProfit(){
        return result * amount;
    }
}
