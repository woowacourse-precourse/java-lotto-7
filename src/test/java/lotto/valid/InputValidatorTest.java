package lotto.valid;

import lotto.view.LottoView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.*;

public class InputValidatorTest {

    @DisplayName("구입 금액 입력이 1,000원 단위일 때 올바르게 처리되는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"1000", "5000", "10000"})
    void getPurchaseAmount_ValidInput(String input) {
        assertThat(InputValidator.validatePurchasePrice(input)).isEqualTo(Integer.parseInt(input));
    }

    @DisplayName("구입 금액 입력이 1,000원 단위가 아닐 때 예외가 발생하는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"1500", "2300", "4999"})
    void getPurchaseAmount_InvalidInput(String input) {
        assertThatThrownBy(() -> InputValidator.validatePurchasePrice(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구입 금액은 1,000원 단위여야 합니다.");
    }

    @DisplayName("올바른 당첨 번호 입력 시 리스트로 반환되는지 확인")
    @Test
    void getWinningNumbers_ValidInput() {
        String input = "1,2,3,4,5,6";
        assertThat(InputValidator.validateWinningNumbers(input)).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("잘못된 당첨 번호 입력 시 예외가 발생하는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"0,2,3,4,5,6", "1,2,3,4,5,46", "1,2,123,4,5,6"})
    void getWinningNumbers_InvalidInput(String input) {
        assertThatThrownBy(() -> InputValidator.validateWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자여야 합니다.");
    }

    @DisplayName("올바른 보너스 번호 입력 시 반환값 확인")
    @ParameterizedTest
    @ValueSource(strings = {"1", "45"})
    void getBonusNumber_ValidInput(String input) {
        assertThat(InputValidator.validateBonusNumber(input)).isEqualTo(Integer.parseInt(input));
    }

    @DisplayName("보너스 번호가 1~45 범위를 벗어날 때 예외가 발생하는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"0", "46", "-1"})
    void getBonusNumber_OutOfRange(String input) {
        assertThatThrownBy(() -> InputValidator.validateBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("문자열 입력 시 숫자 변환 예외가 발생하는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"abc", "1.5", "우와", ""})
    void getBonusNumber_InvalidFormat(String input) {
        assertThatThrownBy(() -> InputValidator.validateBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자로 입력해야 합니다.");
    }
}
