package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class VerifierTest {

    @Test
    @DisplayName("입력된 금액이 유효하지 않을 경우 예외가 발생한다")
    void validateMoneyTest() {
        String invalidInput = "1001";
        assertThatThrownBy(() -> Verifier.validateMoney(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력 금액이 유효하지 않습니다.");
    }

    @Test
    @DisplayName("로또 번호의 개수가 유효하지 않을 경우 예외가 발생한다")
    void validateLottoNumbersTest() {
        String[] invalidInput = {"1", "2", "3", "4", "5"};
        assertThatThrownBy(() -> Verifier.validateLottoNumbers(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("번호 개수는 6개여야 합니다.");
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복될 경우 예외가 발생한다")
    void validateBonusNumberTest() {
        String bonusNumber = "1";
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> Verifier.validateBonusNumber(bonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 값이 존재합니다.");
    }

    @Test
    @DisplayName("로또 번호가 범위를 벗어날 경우 예외가 발생한다")
    void validateLottoNumberTest() {
        String invalidInput = "0";
        assertThatThrownBy(() -> Verifier.validateLottoNumber(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1~45 사이의 정수만 입력 가능합니다.");
    }

    @Test
    @DisplayName("입력값이 정수가 아닐 경우 예외가 발생한다")
    void validateIntegerTest() {
        String invalidInput = "98d";
        assertThatThrownBy(() -> Verifier.validateInteger(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("정수형만 입력 가능합니다.");
    }

    @Test
    @DisplayName("입력값에 중복된 숫자가 있을 경우 예외가 발생한다")
    void validateDuplicateTest() {
        String[] invalidInput = {"1", "2", "3", "4", "5", "5"};
        assertThatThrownBy(() -> Verifier.validateDuplicate(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 값이 존재합니다.");
    }
}
