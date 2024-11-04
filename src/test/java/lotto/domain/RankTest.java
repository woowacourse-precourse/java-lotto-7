package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
class RankTest {
    @Test
    @DisplayName("일치한 숫자 수와 보너스 여부에 따른 등수 부여")
    void getResult() {
        Rank rank1 = getRank(6, false);
        Rank rank2 = getRank(5, true);
        Rank rank3 = getRank(5, false);
        Rank rank4 = getRank(4, false);
        Rank rank5 = getRank(3, false);
        Rank rank6 = getRank(2, false);

        assertEquals(rank1, Rank.FIRST);
        assertEquals(rank2, Rank.SECOND);
        assertEquals(rank3, Rank.THIRD);
        assertEquals(rank4, Rank.FOURTH);
        assertEquals(rank5, Rank.FIFTH);
        assertEquals(rank6, Rank.NON);
    }

    private Rank getRank(int matchingCount, boolean matching) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.getResult(matchingCount, matching))
                .findFirst()
                .orElse(Rank.NON);
    }
}