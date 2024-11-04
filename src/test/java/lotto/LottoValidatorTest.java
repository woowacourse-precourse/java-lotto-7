package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoValidatorTest {

    @DisplayName("로또 번호가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> LottoValidator.validateLottoNumber(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> LottoValidator.validateLottoNumber(List.of(1, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 중복될 수 없습니다.");
    }

    @DisplayName("로또 번호가 1보다 작으면 예외가 발생한다.")
    @Test
    void 로또_번호가_1보다_작으면_예외가_발생한다() {
        assertThatThrownBy(() -> LottoValidator.validateLottoNumber(List.of(0, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("로또 번호가 45보다 크면 예외가 발생한다.")
    @Test
    void 로또_번호가_45보다_크면_예외가_발생한다() {
        assertThatThrownBy(() -> LottoValidator.validateLottoNumber(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("로또 번호가 6개보다 적으면 예외가 발생한다.")
    @Test
    void 로또_번호가_6개보다_적으면_예외가_발생한다() {
        assertThatThrownBy(() -> LottoValidator.validateLottoNumber(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @DisplayName("보너스 번호가 로또 번호와 중복이면 예외가 발생한다.")
    @Test
    void 보너스_번호가_로또_번호와_중복이면_예외가_발생한다() {
        assertThatThrownBy(() -> LottoValidator.validateBonusNumber(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

    @DisplayName("보너스 번호가 1보다 작으면 예외가 발생한다.")
    @Test
    void 보너스_번호가_1보다_작으면_예외가_발생한다() {
        assertThatThrownBy(() -> LottoValidator.validateBonusNumber(List.of(1, 2, 3, 4, 5, 6), 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("보너스 번호가 45보다 크면 예외가 발생한다.")
    @Test
    void 보너스_번호가_45보다_크면_예외가_발생한다() {
        assertThatThrownBy(() -> LottoValidator.validateBonusNumber(List.of(1, 2, 3, 4, 5, 6), 46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
}
