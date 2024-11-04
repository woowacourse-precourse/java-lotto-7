package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class MatchResultTest {

    private static final Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

    @Test
    @DisplayName("로또 번호와 당첨 번호가 일치하는 개수를 계산하고 보너스 번호 일치 여부를 확인한다")
    void matchResultTest() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        int bonusNumber = 10;
        LottoDraw lottoDraw = LottoDraw.of(winningLotto, bonusNumber);

        MatchResult result = MatchResult.of(lotto, lottoDraw);

        assertEquals(3, result.getMatchCount());
        assertFalse(result.isMatchBonus());
    }

    @Test
    @DisplayName("보너스 번호가 일치하는 경우를 확인한다")
    void matchResultWithBonusTest() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 9));
        int bonusNumber = 6;
        LottoDraw lottoDraw = LottoDraw.of(winningLotto, bonusNumber);

        MatchResult result = MatchResult.of(lotto, lottoDraw);

        assertEquals(5, result.getMatchCount());
        assertTrue(result.isMatchBonus());
    }

    @Test
    @DisplayName("일치하는 번호가 없는 경우를 확인한다")
    void noMatchTest() {
        Lotto winningLotto = new Lotto(List.of(10, 11, 12, 13, 14, 15));
        int bonusNumber = 9;
        LottoDraw lottoDraw = LottoDraw.of(winningLotto, bonusNumber);

        MatchResult result = MatchResult.of(lotto, lottoDraw);

        assertEquals(0, result.getMatchCount());
        assertFalse(result.isMatchBonus());
    }
}
