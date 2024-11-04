package lotto.util.validator;

import static lotto.util.message.OutputMessage.ERROR_MESSAGE;
import static lotto.util.validator.LottoNumberValidator.validateDuplicated;
import static lotto.util.validator.LottoNumberValidator.validateInputString;
import static lotto.util.validator.LottoNumberValidator.validateNumberCount;
import static lotto.util.validator.LottoNumberValidator.validateNumberInRange;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberValidatorTests {

    @ParameterizedTest
    @DisplayName("입력한 로또 당첨 번호가 공백문자만 입력되었거나 빈 문자열이면 예외 발생")
    @ValueSource(strings = {"", " "})
    void validateBlankInputExceptionTest(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> validateInputString(input))
                .withMessageStartingWith(ERROR_MESSAGE);
    }

    @ParameterizedTest
    @DisplayName("입력한 로또 당첨 번호에서 쉼표를 잘못 사용했다면 예외 발생")
    @ValueSource(strings = {",1,2,3,4,5,6", "1,2,3,4,5,6,", "1,,2,3,4,5,6"})
    void validateWrongDelimiterExceptionTest(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> validateInputString(input))
                .withMessageStartingWith(ERROR_MESSAGE);
    }

    @ParameterizedTest
    @DisplayName("입력한 로또 당첨 번호가 1~45 사이의 정수가 아니면 예외 발생")
    @ValueSource(strings = {"0", "46"})
    void validateNumberInRangeExceptionTest(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> validateNumberInRange(input))
                .withMessageStartingWith(ERROR_MESSAGE);
    }

    @ParameterizedTest
    @DisplayName("입력한 로또 당첨 번호가 1~45 사이 정수이면 정수형으로 변환")
    @MethodSource("provideInputAndExpectedNumber")
    void validateNumberInRangeTest(String input, Long expectedLottoNumber) {
        assertEquals(validateNumberInRange(input), expectedLottoNumber);
    }

    private static Stream<Arguments> provideInputAndExpectedNumber() {
        return Stream.of(
                Arguments.of("1", 1L),
                Arguments.of("45", 45L)
        );
    }

    @ParameterizedTest
    @DisplayName("입력한 당첨 번호의 개수가 6개가 아니면 예외 발생")
    @MethodSource("provideNumbers")
    void validateNumberCountExceptionTest(List<Integer> numbers) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> validateNumberCount(numbers))
                .withMessageStartingWith(ERROR_MESSAGE);
    }
    private static Stream<List<Integer>> provideNumbers() {
        return Stream.of(
                List.of(1,2,3,4,5,6,7),
                List.of(1,2,3,4,5)
        );
    }

    @Test
    @DisplayName("입력한 6개의 당첨 번호 중 중복된 번호가 있으면 예외 발생")
    void validateDuplicatedWinningNumbersExceptionTest() {
        List<Integer> input = List.of(1, 2, 3, 3, 4, 5);
        assertThatIllegalArgumentException()
                .isThrownBy(() -> validateDuplicated(input))
                .withMessageStartingWith(ERROR_MESSAGE);
    }

    @Test
    @DisplayName("입력한 보너스 번호가 이미 당첨 번호에 포함되어 있으면 예외 발생")
    void validateDuplicatedBonusNumberTest() {
        Lotto lottoInput = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Integer bonusNumberInput = 3;
        assertThatIllegalArgumentException()
                .isThrownBy(() -> validateDuplicated(lottoInput, bonusNumberInput))
                .withMessageStartingWith(ERROR_MESSAGE);
    }
}