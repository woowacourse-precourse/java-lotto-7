package lotto.domain;

import lotto.exception.DuplicatedWinningNumberException;
import lotto.exception.InvalidRangeLottoNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {

    @DisplayName("보너스 번호가 0이하이거나 46이상이면 예외가 발생한다.")
    @Test
    void 보너스_번호가_범위를_벗어나면_예외발생() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 0))
                .isInstanceOf(InvalidRangeLottoNumberException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1~45 사이의 정수여야 합니다.");

        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 46))
                .isInstanceOf(InvalidRangeLottoNumberException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1~45 사이의 정수여야 합니다.");
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void 보너스_번호가_당첨번호와_중복되면_예외발생() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(DuplicatedWinningNumberException.class)
                .hasMessageContaining("[ERROR] 보너스 번호가 당첨 번호와 중복되면 안됩니다.");
    }
}
