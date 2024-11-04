package lotto.model.match;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum MatchInformation {
    THREE_MATCH(3, null),
    FOUR_MATCH(4, null),
    FIVE_MATCH(5, null),
    FIVE_AND_BONUS_MATCH(6, true),
    SIX_MATCH(6, false);

    private final int totalCount;
    private final Boolean isEqualToBonus;

    MatchInformation(int totalCount, Boolean isEqualToBonus) {
        this.totalCount = totalCount;
        this.isEqualToBonus = isEqualToBonus;
    }

    public static MatchInformation of(int totalCount, boolean isEqualToBonus) {
        return Arrays.stream(values())
                .filter(value -> value.totalCount == totalCount
                        && (value.isEqualToBonus == null || value.isEqualToBonus == isEqualToBonus))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("존재하지 않는 MatchInformation Type 입니다."));
    }
}
