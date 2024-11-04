package lotto.global.status;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public enum LottoStatus {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);


    private final Integer matchCount;

    private final Integer prize;


    LottoStatus(Integer matchCount, Integer prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }


    public Integer getPrize() {
        return prize;
    }

    public Integer getMatchCount() {
        return matchCount;
    }

    public static LottoStatus getResult(Integer matchCount, Boolean isBonusMatched) {
        if (matchCount.equals(SECOND.matchCount) && isBonusMatched) {
            return SECOND;
        }

        return Arrays.stream(values())
                .filter(lottoStatus -> !lottoStatus.equals(SECOND) && lottoStatus.matchCount.equals(matchCount))
                .findAny()
                .orElse(NONE);
    }

    public static List<LottoStatus> getAllByAscendingPrize() {
        return Arrays.stream(values())
                .filter(lottoStatus -> !lottoStatus.equals(NONE))
                .sorted(Comparator.comparing(LottoStatus::getPrize))
                .toList();
    }
}
