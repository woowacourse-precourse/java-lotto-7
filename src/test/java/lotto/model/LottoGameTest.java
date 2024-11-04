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
    void 등수_카운트_증가() {
        lottoGame.addResult(Rank.SECOND);
        assertEquals(1, lottoGame.getLottoResult().getRankCount().get(Rank.SECOND));
    }

    @Test
    void 수익률_계산() {
        lottoGame.addResult(Rank.FIRST);
        lottoGame.addResult(Rank.SECOND);
        assertEquals(2030000000.0 / 10000 * 100, lottoGame.calculateReturnRate(), 0.01);
    }
}