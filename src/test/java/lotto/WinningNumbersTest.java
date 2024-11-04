package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.validator.InputValidator.WinningNumberValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinningNumbersTest {

    private static final String ERROR_MESSAGE = "[ERROR]";
    private final WinningNumberValidator validator = new WinningNumberValidator();

    @Test
    @DisplayName("유효한 당첨 번호 입력")
    void testValidWinningNumbers() {
        String input = "5,12,23,30,37,45";
        List<Integer> result = validator.validate(input);
        assertThat(result).containsExactly(5, 12, 23, 30, 37, 45); // 유효한 번호 입력
    }

    @ParameterizedTest
    @CsvSource({
            "abc, 유효한 숫자를 입력해야 합니다.",
            "1,2,3,4,5,100, 로또 번호는 1부터 45 사이여야 합니다.",
            "0,2,3,4,5,6, 로또 번호는 1부터 45 사이여야 합니다.",
            "-1,2,3,4,5,6, 로또 번호는 1부터 45 사이여야 합니다."
    })
    @DisplayName("문자 입력 또는 범위를 초과하는 경우")
    void testInvalidFormatOrOutOfRange(String input, String errorMessage) {
        assertThatThrownBy(() -> validator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("공백 입력 시 예외 발생")
    void testEmptyInput() {
        assertThatThrownBy(() -> validator.validate(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE + " 유효한 숫자를 입력해야 합니다.");
    }

    @Test
    @DisplayName("숫자 개수가 6개가 아닌 경우 예외 발생")
    void testInvalidNumberCount() {
        assertThatThrownBy(() -> validator.validate("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE + " 로또 번호는 6개여야 합니다.");
    }

    @Test
    @DisplayName("중복된 당첨 번호가 있는 경우 예외 발생")
    void testDuplicateNumbers() {
        assertThatThrownBy(() -> validator.validate("1,2,3,3,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE + " 로또 번호에는 중복이 없어야 합니다.");
    }

    @Test
    @DisplayName("공백 문자열 입력 시 예외 발생")
    void testWhitespaceInput() {
        assertThatThrownBy(() -> validator.validate(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE + " 유효한 숫자를 입력해야 합니다.");
    }
}
