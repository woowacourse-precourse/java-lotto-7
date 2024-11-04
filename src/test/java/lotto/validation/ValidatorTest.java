package lotto.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        validator = new Validator();
    }

    @Test
    @DisplayName("구입 금액이 1000원 단위가 아닐 경우 예외가 발생해야 한다.")
    void 구입_금액_검증() {
        assertThatThrownBy(() -> validator.validatePurchaseAmount(1200))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
    }

    @Test
    @DisplayName("당첨 번호가 6개가 아닐 경우 예외가 발생해야 한다.")
    void 당첨_번호_갯수_검증() {
        assertThatThrownBy(() -> validator.validateWinningNumbers(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 정확히 6개여야 합니다.");
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생해야 한다.")
    void 보너스_번호_중복_검증() {
        assertThatThrownBy(() -> validator.validateBonusNumber(1, List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }
}