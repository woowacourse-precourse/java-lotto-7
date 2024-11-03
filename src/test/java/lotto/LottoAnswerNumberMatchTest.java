package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


class LottoAnswerNumberMatchTest {
    @Test
    @DisplayName("당첨 번호 포함/미포함")
    public void testIncludeWinningNumber() {
        LottoAnswer lottoAnswer = new LottoAnswer(List.of(1, 2), 3);
        boolean match = lottoAnswer.isNumberMatch(1);
        boolean noMatch = lottoAnswer.isBonusMatch(4);
        Assertions.assertTrue(match);
        Assertions.assertFalse(noMatch);
    }

    @Test
    @DisplayName("보너스 여부 판단")
    public void testIncludeBonus() {
        LottoAnswer lottoAnswer = new LottoAnswer(List.of(1, 2), 3);
        boolean match = lottoAnswer.isBonusMatch(3);
        boolean noMatch = lottoAnswer.isBonusMatch(4);
        Assertions.assertTrue(match);
        Assertions.assertFalse(noMatch);
    }

}