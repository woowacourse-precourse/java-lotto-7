package lotto.domain;

import lotto.exception.DuplicatedLottoNumberException;
import lotto.exception.InvalidRangeLottoNumberException;
import lotto.exception.InvalidSizeLottoNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @DisplayName("로또 번호가 6자리가 아니면 예외가 발생한다.")
    @Test
    void 로또_번호가_6자리가_아니면_예외발생() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(InvalidSizeLottoNumberException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 6개여야 합니다.");
    }

    @DisplayName("로또 번호가 0이하이거나 46이상이면 예외가 발생한다.")
    @Test
    void 로또_번호가_범위를_벗어나면_예외발생() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(InvalidRangeLottoNumberException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1~45 사이의 정수여야 합니다.");

        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(InvalidRangeLottoNumberException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1~45 사이의 정수여야 합니다.");
    }

    @DisplayName("로또 번호에 중복이 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복이_있으면_예외발생() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(DuplicatedLottoNumberException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 중복되지않는 정수여야 합니다.");
    }
}
