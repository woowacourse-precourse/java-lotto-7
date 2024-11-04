package lotto.validator;

import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoValidatorTest {

    @Test
    @DisplayName("로또 번호는 1에서 45 사이의 값이어야 한다.")
    void testValidateLottoNumbersRange() {
        assertThatThrownBy(() -> LottoValidator.validateLottoNumbers(List.of(0, 1, 2, 3, 4, 5))) // 0 포함
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 1부터 45 사이의 숫자여야 합니다.");

        assertThatThrownBy(() -> LottoValidator.validateLottoNumbers(List.of(1, 2, 3, 4, 5, 46))) // 46 포함
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("로또 번호는 중복될 수 없다.")
    void testValidateUniqueLottoNumbers() {
        assertThatThrownBy(() -> LottoValidator.validateLottoNumbers(List.of(1, 2, 3, 4, 5, 5))) // 중복 번호 포함
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 중복되지 않는 숫자여야 합니다.");
    }

    @Test
    @DisplayName("로또 번호는 6개여야 한다.")
    void testValidateLottoNumbersCount() {
        assertThatThrownBy(() -> LottoValidator.validateLottoNumbers(List.of(1, 2, 3, 4, 5))) // 5개 번호
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 6개의 숫자여야 합니다.");

        assertThatThrownBy(() -> LottoValidator.validateLottoNumbers(List.of(1, 2, 3, 4, 5, 6, 7))) // 7개 번호
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 6개의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("보너스 번호는 로또 번호와 중복될 수 없다.")
    void testValidateBonusNumberDuplicate() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> LottoValidator.validateBonusNumber(1, winningLotto)) // 보너스 번호가 로또 번호에 포함
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
    }

    @Test
    @DisplayName("보너스 번호는 1에서 45 사이의 값이어야 한다.")
    void testValidateBonusNumberRange() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> LottoValidator.validateBonusNumber(0, winningLotto)) // 0 포함
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 번호는 1에서 45 사이의 숫자여야 합니다.");

        assertThatThrownBy(() -> LottoValidator.validateBonusNumber(46, winningLotto)) // 46 포함
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 번호는 1에서 45 사이의 숫자여야 합니다.");
    }
}