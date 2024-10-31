package lotto.domain;

import lotto.constant.Ranking;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class LottoResult {

    private static final int DEFAULT = 0;
    private static final int INCREASE_SIZE = 1;
    private final Map<Ranking, Integer> elements;

    public LottoResult() {
        elements = new EnumMap<>(Ranking.class);
        Arrays.stream(Ranking.values()).forEach(value -> elements.put(value, DEFAULT));
    }

    public void increaseCount(Ranking ranking) {
        elements.put(ranking, elements.get(ranking) + INCREASE_SIZE);
    }
}
