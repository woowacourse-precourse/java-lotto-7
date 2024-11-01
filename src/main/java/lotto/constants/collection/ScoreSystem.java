package lotto.constants.collection;

import lotto.constants.Constants;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public enum ScoreSystem implements Constants<LinkedHashMap> {

    DEFAULT(new LinkedHashMap<>() {{
        put(List.of(3, 0), 0);
        put(List.of(4, 0), 0);
        put(List.of(5, 0), 0);
        put(List.of(5, 1), 0);
        put(List.of(6, 0), 0);
    }});

    private final Map<List<Integer>, Integer> scoringMap;

    ScoreSystem(Map<List<Integer>, Integer> scoringMap) {
        this.scoringMap = scoringMap;
    }

    //방어적 복사
    @Override
    public LinkedHashMap<List<Integer>, Integer> getInstance() {
        return new LinkedHashMap<>(scoringMap);
    }

}
