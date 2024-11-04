package lotto.rank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RankingTest {

    @Test
    void 일치_개수가_6개일_때_FIRST를_반환한다() {
        // Given
        int matchCount = 6;
        boolean bonusMatch = false;

        // When
        Ranking result = Ranking.valueOf(matchCount, bonusMatch);

        // Then
        assertEquals(Ranking.FIRST, result);
    }

    @Test
    void 일치_개수가_5개이고_보너스_번호가_일치할_때_SECOND를_반환한다() {
        // Given
        int matchCount = 5;
        boolean bonusMatch = true;

        // When
        Ranking result = Ranking.valueOf(matchCount, bonusMatch);

        // Then
        assertEquals(Ranking.SECOND, result);
    }

    @Test
    void 일치_개수가_5개이고_보너스_번호가_불일치할_때_THIRD를_반환한다() {
        // Given
        int matchCount = 5;
        boolean bonusMatch = false;

        // When
        Ranking result = Ranking.valueOf(matchCount, bonusMatch);

        // Then
        assertEquals(Ranking.THIRD, result);
    }

    @Test
    void 일치_개수가_4개일_때_FOURTH를_반환한다() {
        // Given
        int matchCount = 4;
        boolean bonusMatch = false;

        // When
        Ranking result = Ranking.valueOf(matchCount, bonusMatch);

        // Then
        assertEquals(Ranking.FOURTH, result);
    }

    @Test
    void 일치_개수가_3개일_때_FIFTH를_반환한다() {
        // Given
        int matchCount = 3;
        boolean bonusMatch = false;

        // When
        Ranking result = Ranking.valueOf(matchCount, bonusMatch);

        // Then
        assertEquals(Ranking.FIFTH, result);
    }

    @Test
    void 일치_개수가_2개일_때_NONE을_반환한다() {
        // Given
        int matchCount = 2;
        boolean bonusMatch = false;

        // When
        Ranking result = Ranking.valueOf(matchCount, bonusMatch);

        // Then
        assertEquals(Ranking.NONE, result);
    }

    @Test
    void 일치_개수가_0개일_때_NONE을_반환한다() {
        // Given
        int matchCount = 0;
        boolean bonusMatch = false;

        // When
        Ranking result = Ranking.valueOf(matchCount, bonusMatch);

        // Then
        assertEquals(Ranking.NONE, result);
    }

}