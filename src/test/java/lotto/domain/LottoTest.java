package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.TestConstants.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨된 개수를 잘 반환한다.")
    void getCountOfMatchedWinningNumbers () {
        // given
        Lotto lotto = new Lotto(LOTTO_NUMBERS_WITH_MATCH_3);
        WinningNumbers winningNumbers = new WinningNumbers(VALID_WINNING_NUMBERS);

        // when
        int count = lotto.countMatchingNumbers(winningNumbers.getWinningNumbers());

        // then
        assertEquals(count, MATCH_COUNT_3);
    }

    @Test
    @DisplayName("보너스 번호 당첨시 true를 반환한다.")
    void matchBonusNumber () {
        // given
        Lotto lotto = new Lotto(LOTTO_NUMBERS_WITH_MATCH_5_AND_BONUS_NUMBER);
        Integer bonusNumber = BONUS_NUMBER;

        // when
        boolean containBonusNumber =  lotto.containBonusNumber(bonusNumber);

        // then
        assertTrue(containBonusNumber);
    }

    @Test
    @DisplayName("보너스 번호갸 당첨되지 않을 시 false를 반환한다.")
    void notMatchBonusNumber () {
        // given
        Lotto lotto = new Lotto(LOTTO_NUMBERS_WITH_MATCH_5);
        Integer bonusNumber = BONUS_NUMBER;

        // when
        boolean containBonusNumber =  lotto.containBonusNumber(bonusNumber);

        // then
        assertFalse(containBonusNumber);
    }
}
