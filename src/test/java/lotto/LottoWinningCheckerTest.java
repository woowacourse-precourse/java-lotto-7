package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoWinningCheckerTest {
    @DisplayName("당첨 번호 갯수가 맞지 않으면 예외가 발생한다")
    @Test
    void 당첨_번호_갯수가_맞지_않으면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoWinningChecker(List.of(1, 2, 3, 4, 5), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 범위 바깥의 숫자가 포함되면 예외가 발생한다")
    @Test
    void 당첨_번호에_범위_바깥의_숫자가_포함되면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoWinningChecker(List.of(1, 2, 3, 4, 5, 60), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호에 범위 바깥의 숫자가 포함되면 예외가 발생한다")
    @Test
    void 보너스_번호에_범위_바깥의_숫자가_포함되면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoWinningChecker(List.of(1, 2, 3, 4, 5, 6), 70))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
