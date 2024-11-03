package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoGameTest {
    private LottoGame lottoGame;

    @BeforeEach
    void setUp() {
        lottoGame = new LottoGame(10000);
    }

    @Test
    void addResult_ShouldIncreaseRankCount() {
        lottoGame.addResult(Rank.SECOND);
        assertEquals(1, lottoGame.getLottoResult().getRankCount().get(Rank.SECOND));
    }

    @Test
    void calculateReturnRate_ShouldReturnCorrectRate() {
        lottoGame.addResult(Rank.FIRST);
        lottoGame.addResult(Rank.SECOND);
        assertEquals(2030000000.0 / 10000 * 100, lottoGame.calculateReturnRate(), 0.01);
    }
}