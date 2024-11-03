package validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumbersValidateTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("validateUniqueElements 정수 중복 입력 테스트")
    @Test
    void validateUniqueElements_정수_중복_입력_테스트() {
        assertThatThrownBy(() -> Validator.validateUniqueElements(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("validateUniqueElements 문자열 중복 입력 테스트")
    @Test
    void validateUniqueElements_문자열_중복_입력_테스트() {
        assertThatThrownBy(
                () -> Validator.validateUniqueElements(List.of("aespa", "IVE", "NMIXX", "NewJeans", "NewJeans")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("validateUniqueElements 정상 검증 테스트")
    @Test
    void validateUniqueElements_정상_검증_테스트() {
        assertThatCode(() -> Validator.validateUniqueElements(List.of(1, 2, 3, "aespa", "fromis_9")))
                .doesNotThrowAnyException();
    }

    @DisplayName("validateNumberInLottoRange 범위 외 입력 테스트")
    @Test
    void validateNumberInLottoRange_범위_외_입력_테스트() {
        assertThatThrownBy(
                () -> Validator.validateNumberInLottoRange(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("validateUniqueElements 정상 검증 테스트")
    @Test
    void validateNumberInLottoRange_정상_검증_테스트() {
        assertThatCode(() -> Validator.validateNumberInLottoRange(45))
                .doesNotThrowAnyException();
    }

    @DisplayName("WinningNumbers 크기 입력 오류 테스트")
    @Test
    void WinningNumbers_크기_입력_오류_테스트() {
        assertThatThrownBy(
                () -> Validator.validateWinningNumbers(List.of("1", "3", "6", "10", "15", "21", "28")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("WinningNumbers 문자열 입력 오류 테스트")
    @Test
    void WinningNumbers_문자열_입력_오류_테스트() {
        assertThatThrownBy(
                () -> Validator.validateWinningNumbers(List.of("1", "3", "6", "aespa", "IVE", "TripleS")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("WinningNumbers 범위 외 값 입력 테스트")
    @Test
    void WinningNumbers_범위_외_값_입력_테스트() {
        assertThatThrownBy(
                () -> Validator.validateWinningNumbers(List.of("1", "3", "6", "10", "15", "210")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("WinningNumbers 정상 검증 테스트")
    @Test
    void validateWinningNumbers_정상_검증_테스트() {
        assertThatCode(() -> Validator.validateWinningNumbers(List.of("1", "3", "5", "10", "15", "21")))
                .doesNotThrowAnyException();
    }
}
