package lotto;

import lotto.validation.InputValidate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidateTest {

    private final InputValidate validator = new InputValidate();

    @DisplayName("구매 금액이 null일 경우 예외가 발생한다.")
    @Test
    void 구매_금액이_null일_경우_예외가_발생한다() {
        assertThatThrownBy(() -> validator.validatePurchaseAmount(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 비어 있을 수 없습니다.");
    }

    @DisplayName("구매 금액이 0 이하일 경우 예외가 발생한다.")
    @Test
    void 구매_금액이_0_이하일_경우_예외가_발생한다() {
        assertThatThrownBy(() -> validator.validatePurchaseAmount(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 0보다 큰 양수여야 합니다.");
    }

    @DisplayName("구매 금액이 1,000원 단위가 아닐 경우 예외가 발생한다.")
    @Test
    void 구매_금액이_1000원_단위가_아닐_경우_예외가_발생한다() {
        assertThatThrownBy(() -> validator.validatePurchaseAmount(1500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
    }

    @DisplayName("보너스 번호가 null일 경우 예외가 발생한다.")
    @Test
    void 보너스_번호가_null일_경우_예외가_발생한다() {
        assertThatThrownBy(() -> validator.validateBonusNumber(null, List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 비어 있을 수 없습니다.");
    }

    @DisplayName("보너스 번호가 1~45 범위를 벗어날 경우 예외가 발생한다.")
    @Test
    void 보너스_번호가_1에서_45_범위를_벗어날_경우_예외가_발생한다() {
        assertThatThrownBy(() -> validator.validateBonusNumber(46, List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 1에서 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복될 경우 예외가 발생한다.")
    @Test
    void 보너스_번호가_당첨_번호와_중복될_경우_예외가_발생한다() {
        assertThatThrownBy(() -> validator.validateBonusNumber(5, List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }
}
