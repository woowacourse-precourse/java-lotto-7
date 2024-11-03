package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoRankTest {

    @ParameterizedTest
    @EnumSource(LottoRank.class)
    @DisplayName("LottoRank 예상대로 설정되었는지 확인")
    void testLottoRankFields(LottoRank rank) {
        switch (rank) {
            case FIRST:
                assertEquals(6, rank.getMatchCount());
                assertEquals(2_000_000_000, rank.getPrizeAmount());
                assertEquals("6개 일치 (2,000,000,000원)", rank.getDescription());
                break;
            case SECOND:
                assertEquals(5, rank.getMatchCount());
                assertEquals(30_000_000, rank.getPrizeAmount());
                assertEquals("5개 일치, 보너스 볼 일치 (30,000,000원)", rank.getDescription());
                break;
            case THIRD:
                assertEquals(5, rank.getMatchCount());
                assertEquals(1_500_000, rank.getPrizeAmount());
                assertEquals("5개 일치 (1,500,000원)", rank.getDescription());
                break;
            case FOURTH:
                assertEquals(4, rank.getMatchCount());
                assertEquals(50_000, rank.getPrizeAmount());
                assertEquals("4개 일치 (50,000원)", rank.getDescription());
                break;
            case FIFTH:
                assertEquals(3, rank.getMatchCount());
                assertEquals(5_000, rank.getPrizeAmount());
                assertEquals("3개 일치 (5,000원)", rank.getDescription());
                break;
        }
    }
}
