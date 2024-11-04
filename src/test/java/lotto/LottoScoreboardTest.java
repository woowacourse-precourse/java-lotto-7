package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoScoreboardTest {
    private LottoScoreboard scoreboard;

    @BeforeEach
    void setUp() {
        scoreboard = new LottoScoreboard(100000, 0);
    }
    @DisplayName("3개 맞췄을 때 로또 스코어 보드 값 증가 함수 테스트")
    @Test
    void testIncrementThreeMatches() {
        scoreboard.incrementThreeMatches();
        assertEquals(1, scoreboard.getThreeMatches());
    }

    @DisplayName("4개 맞췄을 때 로또 스코어 보드 값 증가 함수 테스트")
    @Test
    void testIncrementFourMatches() {
        scoreboard.incrementFourMatches();
        assertEquals(1, scoreboard.getFourMatches());
    }

    @DisplayName("5개 맞췄을 때 로또 스코어 보드 값 증가 함수 테스트")
    @Test
    void testIncrementFiveMatches() {
        scoreboard.incrementFiveMatches();
        assertEquals(1, scoreboard.getFiveMatches());
    }

    @DisplayName("5개와 보너스 숫자 맞췄을 때 로또 스코어 보드 값 증가 함수 테스트")
    @Test
    void testIncrementFiveBonusMatches() {
        scoreboard.incrementFiveBonusMatches();
        assertEquals(1, scoreboard.getFiveBonusMatches());
    }

    @DisplayName("6개 맞췄을 때 로또 스코어 보드 값 증가 함수 테스트")
    @Test
    void testIncrementSixMatches() {
        scoreboard.incrementSixMatches();
        assertEquals(1, scoreboard.getSixMatches());
    }

    @DisplayName("로또 수익률 올바르게 나오는지 테스트")
    @Test
    void testCalculateTotalProfit() {
        scoreboard.incrementThreeMatches();
        scoreboard.incrementFourMatches();

        String profit = scoreboard.calculateTotalProfit();
        assertEquals("55.0%", profit);
    }

}

