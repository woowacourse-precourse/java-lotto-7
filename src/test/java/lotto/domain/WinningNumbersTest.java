package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

public class WinningNumbersTest {

    @Test
    void 중복인_경우_예외가_발생한다() {
        assertThatThrownBy(() -> WinningNumbers.of(List.of(1, 2, 3, 4, 5, 6), 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 범위를_초과하는_입력인_경우_예외가_발생한다() {
        assertThatThrownBy(() -> WinningNumbers.of(List.of(1, 2, 3, 4, 5, 6), 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 올바른_입력_시_당첨번호가_생성된다() {
        // given & when
        WinningNumbers winningNumbers = WinningNumbers.of(List.of(1, 2, 3, 4, 5, 6), 7);

        // then
        assertThat(winningNumbers).isNotNull();
        assertThat(winningNumbers.lotto().numbers()).hasSize(6);
        assertThat(winningNumbers.bonusNumber().number()).isEqualTo(7);
    }
}
