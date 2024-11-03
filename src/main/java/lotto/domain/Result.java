package lotto.domain;

import lotto.message.InfoMessage;

import java.util.Arrays;
import java.util.function.BiPredicate;

import static lotto.message.InfoMessage.*;

public enum Result {

    ZERO(false, null,
            (match, bonus) -> match == 0),

    ONE(false, null,
            (match, bonus) -> match == 1),

    TWO(false, null,
            (match, bonus) -> match == 2),

    THREE(true, THREE_NUMBERS_MATCH,
            (match, bonus) -> match == 3),

    FOUR(true, FOUR_NUMBERS_MATCH,
            (match, bonus) -> match == 4),

    FIVE(true, FIVE_NUMBERS_MATCH,
            (match, bonus) -> match == 5 && !bonus),

    FIVE_WITH_BONUS(true, FIVE_NUMBERS_MATCH_WITH_BONUS,
            (match, bonus) -> match == 5 && bonus),

    SIX(true, SIX_NUMBERS_MATCH,
            (match, bonus) -> match == 6);

    public boolean print;
    private InfoMessage infoMessage;
    private int result;
    private BiPredicate<Integer, Boolean> predicate;

    Result(boolean print, InfoMessage infoMessage, BiPredicate<Integer, Boolean> predicate) {
        this.print = print;
        this.infoMessage = infoMessage;
        this.result = 0;
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
                .orElse(ZERO);
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
}
