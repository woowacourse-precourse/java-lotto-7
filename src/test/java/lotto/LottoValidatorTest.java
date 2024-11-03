package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoValidatorTest {

    @Test
    void 당첨번호_개수가_유효하지_않을_때() {
        assertThatThrownBy(() -> LottoValidator.validateWinningNumbers(List.of(1, 2, 3, 4, 5), 6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @Test
    void 보너스번호가_당첨번호와_중복될_때() {
        assertThatThrownBy(() -> LottoValidator.validateWinningNumbers(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

    @Test
    void 당첨번호가_범위를_벗어날_때() {
        assertThatThrownBy(() -> LottoValidator.validateWinningNumbers(List.of(1, 2, 3, 4, 5, 46), 7))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
}