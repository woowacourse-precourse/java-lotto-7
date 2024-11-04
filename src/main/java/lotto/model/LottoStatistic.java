package lotto.model;

import java.util.EnumMap;
import lotto.MatchType;
import lotto.view.OutputView;

public class LottoStatistic {
    private static final int INITIAL_SETTING = 0;
    private static final int INCREMENT_BY_ONE = 1;
    private final EnumMap<MatchType, Integer> statistics = new EnumMap<>(MatchType.class);
    private OutputView view;
    private LottoGameDTO dto;

    public LottoStatistic(LottoGameDTO dto, OutputView view) {
        for (MatchType type : MatchType.values()) {
            statistics.put(type, INITIAL_SETTING);
        }
        this.dto = dto;
        this.view = view;
    }

    public void update(MatchType type) {
        statistics.put(type, statistics.get(type) + INCREMENT_BY_ONE);
    }

    public int calculateScore() {
        int total = 0;
        for (MatchType type : MatchType.values()) {
            total += statistics.get(type) * type.getPrise();
        }
        return total;
    }

    public checkMatch(){
        for (Lotto lotto : lottos) {
            Arrays.stream(lotto.displayNumbers().split(","));
        }
    }
}
