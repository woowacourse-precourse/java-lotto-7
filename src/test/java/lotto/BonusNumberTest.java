package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import lotto.validator.InputValidator.BonusNumberValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BonusNumberTest {

    private static final String ERROR_MESSAGE = "[ERROR]";
    private final List<Integer> WinningNumbers = Arrays.asList(5, 12, 23, 30, 37, 45);
    private final BonusNumberValidator validator = new BonusNumberValidator();

    @Test
    @DisplayName("유효한 보너스 번호 입력")
    void testValidBonusNumber() {
        assertThat(validator.validate("7", WinningNumbers)).isEqualTo(7);
        assertThat(validator.validate("1", WinningNumbers)).isEqualTo(1);  // 경계 값 테스트
        assertThat(validator.validate("44", WinningNumbers)).isEqualTo(44); // 경계 값 테스트
    }

    @ParameterizedTest
    @CsvSource({
            "abc, 유효한 숫자를 입력해야 합니다.",
            "2147483648, 입력이 정수 범위를 초과합니다.",
            "-1, 로또 번호는 1부터 45 사이의 숫자여야 합니다.",
            "46, 로또 번호는 1부터 45 사이의 숫자여야 합니다."
    })
    @DisplayName("문자 입력 또는 범위를 초과하는 경우")
    void testInvalidFormatOrOutOfRange(String input, String errorMessage) {
        assertThatThrownBy(() -> validator.validate(input, WinningNumbers))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("공백 입력 시 예외 발생")
    void testEmptyInput() {
        assertThatThrownBy(() -> validator.validate("", WinningNumbers))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("공백 문자열 입력 시 예외 발생")
    void testWhitespaceInput() {
        assertThatThrownBy(() -> validator.validate(" ", WinningNumbers))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복될 때 예외 발생")
    void testBonusNumberDuplicate() {
        assertThatThrownBy(() -> BonusNumberValidator.checkDuplicate(WinningNumbers, 5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE + " 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }
}
