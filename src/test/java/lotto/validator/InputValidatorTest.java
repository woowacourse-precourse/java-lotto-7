package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class InputValidatorTest {

    @ParameterizedTest
    @MethodSource("provideInvalidPurchaseAmounts")
    @DisplayName("구입 금액 유효성 검사: 잘못된 금액일 경우 예외 발생")
    void validatePurchaseAmount_shouldThrowException_whenInvalidAmount(String input) {
        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> InputValidator.validatePurchaseAmount(input));
    }

    private static List<Arguments> provideInvalidPurchaseAmounts() {
        return Arrays.asList(
                Arguments.of(""),
                Arguments.of("-1000"),
                Arguments.of("150000"),
                Arguments.of("notANumber"),
                Arguments.of("999")
        );
    }

    @ParameterizedTest
    @MethodSource("provideValidPurchaseAmounts")
    @DisplayName("구입 금액 유효성 검사: 유효한 금액일 경우 예외 발생하지 않음")
    void validatePurchaseAmount_shouldNotThrowException_whenValidAmount(String input) {
        // then
        InputValidator.validatePurchaseAmount(input);
    }

    private static List<Arguments> provideValidPurchaseAmounts() {
        return Arrays.asList(
                Arguments.of("1000"),
                Arguments.of("5000"),
                Arguments.of("100000")
        );
    }

    @ParameterizedTest
    @MethodSource("provideInvalidWinningNumbers")
    @DisplayName("당첨 번호 유효성 검사: 잘못된 번호일 경우 예외 발생")
    void validateWinningNumber_shouldThrowException_whenInvalidWinningNumbers(String input) {

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> InputValidator.validateWinningNumber(input));
    }

    private static List<Arguments> provideInvalidWinningNumbers() {
        return Arrays.asList(
                Arguments.of("1,2,3,4,5"),
                Arguments.of("1,2,3,4,5,5"),
                Arguments.of("1,2,3,4,5,46"),
                Arguments.of("1,2,3,4,5,-1")
        );
    }

    @ParameterizedTest
    @MethodSource("provideValidWinningNumbers")
    @DisplayName("당첨 번호 유효성 검사: 유효한 번호일 경우 예외 발생하지 않음")
    void validateWinningNumber_shouldNotThrowException_whenValidWinningNumbers(String input) {
        // then
        InputValidator.validateWinningNumber(input);
    }

    private static List<Arguments> provideValidWinningNumbers() {
        return Arrays.asList(
                Arguments.of("1,2,3,4,5,6"),
                Arguments.of("10,20,30,40,41,42")
        );
    }

    @ParameterizedTest
    @MethodSource("provideInvalidBonusNumbers")
    @DisplayName("보너스 번호 유효성 검사: 잘못된 번호일 경우 예외 발생")
    void validateBonusNumber_shouldThrowException_whenInvalidBonusNumber(String input, List<Integer> winningNumbers) {
        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> InputValidator.validateBonusNumber(input, winningNumbers));
    }

    private static List<Arguments> provideInvalidBonusNumbers() {
        return Arrays.asList(
                Arguments.of("46", List.of(1, 2, 3, 4, 5, 6)),
                Arguments.of("0", List.of(1, 2, 3, 4, 5, 6)),
                Arguments.of("5", List.of(1, 2, 3, 4, 5, 6))
        );
    }

    @ParameterizedTest
    @MethodSource("provideValidBonusNumbers")
    @DisplayName("보너스 번호 유효성 검사: 유효한 번호일 경우 예외 발생하지 않음")
    void validateBonusNumber_shouldNotThrowException_whenValidBonusNumber(String input, List<Integer> winningNumbers) {
        // then
        InputValidator.validateBonusNumber(input, winningNumbers);
    }

    private static List<Arguments> provideValidBonusNumbers() {
        return Arrays.asList(
                Arguments.of("7", List.of(1, 2, 3, 4, 5, 6)),
                Arguments.of("8", List.of(1, 2, 3, 4, 5, 6))
        );
    }
}
