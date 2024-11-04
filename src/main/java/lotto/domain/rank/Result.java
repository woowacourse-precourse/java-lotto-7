package lotto.domain.rank;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import lotto.domain.Payment;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.domain.winning.AnswerNumbers;

public class Result {

    private static final int PERCENTAGE = 100;
    private static final int INCREMENT = 1;
    private static final int INITIAL = 0;

    private Map<Rank, Integer> results;

    private Result(Lottos lottos, AnswerNumbers answerNumbers) {
        setUp();
        process(lottos, answerNumbers);
    }

    public static Result of(Lottos lottos, AnswerNumbers answerNumbers) {
        return new Result(lottos, answerNumbers);
    }

    private void setUp() {
        this.results = new EnumMap<>(Rank.class);
        Arrays.stream(Rank.values())
                .forEach(rank -> results.put(rank, INITIAL));
    }

    private void process(Lottos lottos, AnswerNumbers answerNumbers) {
        for (Lotto lotto : lottos.getLottos()) {
            count(answerNumbers.compare(lotto));
        }
    }

    private void count(Rank rank) {
        results.put(rank, results.get(rank) + INCREMENT);
    }

    public double calculateProfitRate(Payment payment) {
        return payment.divide(getTotalProfit()) * PERCENTAGE;
    }

    private long getTotalProfit() {
        return results.keySet().stream()
                .mapToLong(rank -> rank.calculatePrize(
                        results.get(rank)
                ))
                .sum();
    }

    public int getCount(Rank rank) {
        return results.get(rank);
    }
}
