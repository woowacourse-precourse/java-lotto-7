package lotto.domain;

import java.util.EnumMap;
import lotto.domain.constant.Ranking;

public class Result {

    EnumMap<Ranking, Integer> results;

    private Result() {
        results = new EnumMap<>(Ranking.class);
        initResults();
    }

    public static Result from() {
        return new Result();
    }

    private void initResults() {
        for (Ranking rank : Ranking.values()) {
            results.put(rank, 0);
        }
    }

    public void updateResults(Integer matchingNumber, boolean hasBonusNumber) {
        Ranking ranking = Ranking.getRanking(matchingNumber, hasBonusNumber);
        results.merge(ranking, 1, Integer::sum);
    }

    public Integer getResultCount(Ranking ranking) {
        return results.get(ranking);
    }

    public EnumMap<Ranking, Integer> getResults() {
        return results;
    }
}
