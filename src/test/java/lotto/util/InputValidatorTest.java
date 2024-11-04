package lotto.util;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Test
    @DisplayName("구입 금액이 1,000원 단위가 아니면 예외 발생")
    void validatePurchaseAmount_notMultipleOfThousand_throwsException() {
        int amount = 1500;
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
    }

    @Test
    @DisplayName("구입 금액이 1,000원 미만이면 예외 발생")
    void validatePurchaseAmount_lessThanThousand_throwsException() {
        int amount = 500;
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1,000원 이상이어야 합니다.");
    }

    @Test
    @DisplayName("구입 금액이 1,000원 단위이면 통과")
    void validatePurchaseAmount_validAmount_passes() {
        int amount = 5000;
        assertThatCode(() -> InputValidator.validatePurchaseAmount(amount))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외 발생")
    void validateWinningNumbers_duplicatedNumbers_throwsException() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 3, 5, 6);
        assertThatThrownBy(() -> InputValidator.validateWinningNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
    }

    @Test
    @DisplayName("보너스 번호가 1부터 45 사이가 아니면 예외 발생")
    void validateBonusNumber_outOfRange_throwsException() {
        int bonusNumber = 46;
        assertThatThrownBy(() -> InputValidator.validateBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("숫자가 아닌 입력값을 파싱할 때 예외 발생")
    void parseNumbers_nonNumericInput_throwsException() {
        String input = "1, 2, three, 4, 5, 6";
        assertThatThrownBy(() -> InputValidator.parseNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력할 수 있습니다.");
    }
}

