package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {
    private final WinningLotto winningLotto = new WinningLotto();
    private static final int MAX = 45;
    private static final int MIN = 1;

    @BeforeEach
    void setUp() {
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6);
        winningLotto.addWinningLotto(input);
    }

    @DisplayName("보너스 번호와 당첨 번호와 중첩되면 예외가 발생한다")
    @Test
    void 보너스번호와_당첨번호가_중첩되면_예외가_발생한다() {
        int bonusNumber = 5;
        assertThatThrownBy(() -> winningLotto.saveBonusNumber(bonusNumber, MAX, MIN))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호와 당첨 번호와 중첩되면 예외가 발생한다")
    @Test
    void 범위밖의_보너스번호이면_예외가_발생한다() {
        int bonusNumber = 46;
        assertThatThrownBy(() -> winningLotto.saveBonusNumber(bonusNumber, MAX, MIN))
                .isInstanceOf(IllegalArgumentException.class);
    }
}