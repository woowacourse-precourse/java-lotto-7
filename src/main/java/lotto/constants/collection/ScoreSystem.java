package lotto.constants.collection;

import lotto.constants.Constants;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * ScoreSystem과 SystemReward는 Score 객체에 들어가게 되는 점수 관련 세팅입니다.
 * DEFAULT는 점수 산출용 기록판이라고 생각하시면 될 것 같습니다.
 * 기록판의 구조는 ( 조합 List(겹치는 숫자, 보너스 숫자 일치 여부), 조합 등장 횟수) 입니다.
 */
public enum ScoreSystem implements Constants<LinkedHashMap<List<Integer>,Integer>> {

    DEFAULT(new LinkedHashMap<>() {{
        put(List.of(3, 0), 0);
        put(List.of(4, 0), 0);
        put(List.of(5, 0), 0);
        put(List.of(5, 1), 0);
        put(List.of(6, 0), 0);
    }});

    private final LinkedHashMap<List<Integer>, Integer> scoringMap;

    ScoreSystem(LinkedHashMap<List<Integer>, Integer> scoringMap) {
        this.scoringMap = scoringMap;
    }

    //방어적 복사
    @Override
    public LinkedHashMap<List<Integer>, Integer> getInstance() {
        return new LinkedHashMap<>(scoringMap);
    }

}
