package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;

public class Result {

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
                .forEach(rank -> results.put(rank, 0));
    }

    private void process(Lottos lottos, AnswerNumbers answerNumbers) {
        for (Lotto lotto : lottos.getLottos()) {
            count(answerNumbers.compare(lotto));
        }
    }

    private void count(Rank rank) {
        results.put(rank, results.get(rank) + 1);
    }

    public double calculateProfitRate(Payment payment) {
        return payment.divide(getTotalProfit()) * 100;
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
