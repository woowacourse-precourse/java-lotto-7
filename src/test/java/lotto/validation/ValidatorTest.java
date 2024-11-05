package lotto.validation;

import static lotto.util.Constant.MAX_PURCHASE_AMOUNT;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import lotto.util.MessageSource;
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
    void 구입_금액_단위_검증() {
        assertThatThrownBy(() -> validator.validatePurchaseAmount(1200))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MessageSource.getMessage("error.invalid_Amount_Unit"));
    }

    @Test
    @DisplayName("구매 금액이 최대 금액을 초과하면 예외가 발생해야 한다.")
    void 구매_금액_초과_검증() {
        int purchaseAmount = MAX_PURCHASE_AMOUNT + 1000;

        assertThatThrownBy(() -> validator.validatePurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MessageSource.getMessage("error.exceeds_max_amount"));
    }

    @Test
    @DisplayName("당첨 번호가 6개가 아닐 경우 예외가 발생해야 한다.")
    void 당첨_번호_갯수_검증() {
        assertThatThrownBy(() -> validator.validateWinningNumbers(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MessageSource.getMessage("error.invalid_winning_number_count"));
    }

    @Test
    @DisplayName("당첨 번호에 범위를 벗어난 숫자가 포함되면 예외가 발생해야 한다.")
    void 당첨_번호_범위_검증() {
        List<Integer> winningNumbers = Arrays.asList(3, 12, 25, 41, 48, 7);

        assertThatThrownBy(() -> validator.validateWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MessageSource.getMessage("error.invalid_number_range"));
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생해야 한다.")
    void 보너스_번호_중복_검증() {
        assertThatThrownBy(() -> validator.validateBonusNumber(1, List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MessageSource.getMessage("error.duplicate_bonus_number"));
    }

    @Test
    @DisplayName("보너스 번호가 범위를 벗어나면 예외가 발생해야 한다.")
    void 보너스_번호_범위_검증() {
        List<Integer> winningNumbers = Arrays.asList(3, 12, 25, 41, 7, 9);
        int bonusNumber = 50;

        assertThatThrownBy(() -> validator.validateBonusNumber(bonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MessageSource.getMessage("error.invalid_number_range"));
    }
}