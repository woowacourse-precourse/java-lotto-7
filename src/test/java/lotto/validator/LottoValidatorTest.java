package lotto.validator;

import lotto.validator.LottoValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoValidatorTest {
    @DisplayName("로또 번호는 1부터 45사이여야 한다.")
    @Test
    void 로또_번호는_1부터_45사이여야_한다() {
        assertThatThrownBy(() -> LottoValidator.validateWinningNumbers(List.of(0, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("번호는 1부터 45 사이의 숫자여야 합니다.");
        assertThatThrownBy(() -> LottoValidator.validateWinningNumbers(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("보너스 번호는 당첨 번호와 중복될 수 없다.")
    @Test
    void 보너스_번호는_당첨_번호와_중복될_수_없다() {
        assertThatThrownBy(() -> LottoValidator.validateBonusNumber(1, List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }
}