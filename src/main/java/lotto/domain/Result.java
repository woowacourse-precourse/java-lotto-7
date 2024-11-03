package lotto.domain;


import java.util.EnumMap;
import java.util.Map;

public class Result {
    private static final Result result = new Result();
    private final Map<Ranking, Integer> resultMap = new EnumMap<>(Ranking.class);
    private int winPrize;

    private Result() {
        for (Ranking ranking : Ranking.values()) {
            resultMap.put(ranking, 0);
        }
        winPrize = 0;
    }

    public static Result getResult() {
        return result;
    }

    public void addWinCount(Ranking ranking) {
        resultMap.put(ranking, resultMap.get(ranking) + 1);
    }

    public int getWinCount(Ranking ranking) {
        return resultMap.get(ranking);
    }

    public void addWinPrize(Ranking ranking) {
        winPrize += ranking.getPrize();
    }

    public int getWinPrize() {
        return winPrize;
    }
}
