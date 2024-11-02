package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    private final InputValidator inputValidator = new InputValidator();

    @DisplayName("빈 입력 테스트(구입 금액)")
    @ParameterizedTest
    @NullAndEmptySource
    void emptyAmountTest(String input) {
        assertThatThrownBy(() -> inputValidator.validateInputAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InputValidator.EMPTY_INPUT_EXCEPTION);
    }

    @DisplayName("숫자 외 문자 입력 테스트(구입 금액)")
    @ParameterizedTest
    @ValueSource(strings = {"팔천", "2000원", " 8000", "abc", "$", "-20000"})
    void invalidCharacterTest(String input) {
        assertThatThrownBy(() -> inputValidator.validateInputAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InputValidator.INVALID_CHARACTER_INPUT_EXCEPTION);
    }

    @DisplayName("최대 범위 초과 입력 테스트(구입 금액)")
    @ParameterizedTest
    @ValueSource(strings = {"21474836482"})
    void exceedMaxAreaTest(String input) {
        assertThatThrownBy(() -> inputValidator.validateInputAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InputValidator.EXCEED_MAX_AREA_EXCEPTION);
    }

    @DisplayName("최소 금액 미만 입력 테스트(구입 금액)")
    @ParameterizedTest
    @ValueSource(strings = {"100", "0", "999"})
    void minAmountTest(String input) {
        assertThatThrownBy(() -> inputValidator.validateInputAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InputValidator.UNDER_MIN_AMOUNT_INPUT_EXCEPTION);
    }

    @DisplayName("1000원 단위 입력 테스트(구입 금액)")
    @ParameterizedTest
    @ValueSource(strings = {"1001", "2200", "11111"})
    void amountUnitTest(String input) {
        assertThatThrownBy(() -> inputValidator.validateInputAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InputValidator.INVALID_AMOUNT_UNIT_EXCEPTION);
    }

    @DisplayName("구입 금액 정상 입력 테스트(구입 금액)")
    @ParameterizedTest
    @ValueSource(strings = {"1000", "8000", "100000"})
    void validAmountTest(String input) {
        assertThatCode(() -> inputValidator.validateInputAmount(input))
                .doesNotThrowAnyException();
    }

    @DisplayName("빈 입력 테스트(당첨 번호)")
    @ParameterizedTest
    @NullAndEmptySource
    void emptyWinningNumberTest(String input) {
        assertThatThrownBy(() -> inputValidator.validateInputWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InputValidator.EMPTY_INPUT_EXCEPTION);
    }


    @DisplayName("유효 문자 입력 테스트(당첨 번호)")
    @ParameterizedTest
    @ValueSource(strings = {"팔,2", " 8,2,3", "a,2", "abc", "$", "-2,1,3"})
    void invalidWinningNumberCharacterTest(String input) {
        assertThatThrownBy(() -> inputValidator.validateInputWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 잘못된 당첨 번호를 입력하셨습니다."
                        + " 당첨 번호 입력은 숫자와 구분자(,)로만 이루어져야 합니다.");
    }

    @DisplayName("빈 구분된 값 테스트(당첨 번호)")
    @ParameterizedTest
    @ValueSource(strings = {"1,,2,3,4", "1,,,2,3,4"})
    void invalidSeparatedNumberTest(String input) {
        assertThatThrownBy(() -> inputValidator.validateInputWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 잘못된 당첨 번호를 입력하셨습니다."
                        + " 구분자 사이에 반드시 숫자가 존재해야 합니다.");
    }

    @DisplayName("포맷(시작,끝 구분자) 테스트(당첨 번호)")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,", ",1,2", ",1,2,"})
    void validateFormatTest(String input) {
        assertThatThrownBy(() -> inputValidator.validateInputWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 잘못된 당첨 번호를 입력하셨습니다."
                        + " 당첨 번호 입력의 시작과 끝은 숫자로 이루어져야 합니다.");
    }

    @DisplayName("번호 범위 테스트(당첨 번호)")
    @ParameterizedTest
    @ValueSource(strings = {"200,12,5", "0,1,2,3"})
    void validateNumberAreaTest(String input) {
        assertThatThrownBy(() -> inputValidator.validateInputWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 잘못된 당첨 번호를 입력하셨습니다."
                        + " 당첨 번호는 1~45까지의 숫자만 가능합니다.");
    }

    @DisplayName("중복 번호 테스트(당첨 번호)")
    @ParameterizedTest
    @ValueSource(strings = {"1,1,1,1,45"})
    void validateNumberDuplicationTest(String input) {
        assertThatThrownBy(() -> inputValidator.validateInputWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 잘못된 당첨 번호를 입력하셨습니다."
                        + " 당첨 번호는 중복 될 수 없습니다.");
    }

    @DisplayName("당첨 번호 정상 입력 테스트(당첨 번호)")
    @ParameterizedTest
    @MethodSource("generateData")
    void validWinningNumberTest(String input, List<Integer> expected) {
        assertThat(inputValidator.validateInputWinningNumber(input))
                .hasSameSizeAs(expected)
                .containsAll(expected);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of("2,3,4,5,6,8", List.of(2, 3, 4, 5, 6, 8)),
                Arguments.of("10,11,23,24,26,27", List.of(10, 11, 23, 24, 26, 27))
        );
    }
}