package lotto.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class InputValidatorTest {
    private final static String ERROR_HEADER = "[ERROR] ";

    @ParameterizedTest
    @DisplayName("로또 구매 금액 입력 테스트")
    @MethodSource("makeMoneyException")
    void validateMoney_Test(String input) {
        assertThatThrownBy(() -> InputValidator.validateMoney(input))
                .isInstanceOf(Exception.class)
                .hasMessageContaining(ERROR_HEADER);
    }

    public static Stream<Arguments> makeMoneyException() {
        return Stream.of(
                Arguments.argumentSet("null and empty case", "", " ", "\n", null),
                Arguments.argumentSet("not digit case", "hi", "I'm MinJun!"),
                Arguments.argumentSet("not divided by 1000 case", "100", "1234", "55555")
        );
    }

    @ParameterizedTest
    @DisplayName("로또 번호 입력 테스트")
    @MethodSource("makeLottoNumberException")
    void validateLottoNumber_Test(String input) {
        assertThatThrownBy(() -> InputValidator.validateLottoNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_HEADER);
    }

    public static Stream<Arguments> makeLottoNumberException() {
        return Stream.of(
                Arguments.argumentSet("not 6 number case", "1, 2, 3, 4, 5", "1,2,3,4,5,6,7"),
                Arguments.argumentSet("not digit case", "hi, minjun, 1,2,3,4"),
                Arguments.argumentSet("not in range case", "1,2,3,4,50,6", "0, 1,2,3,4,5"),
                Arguments.argumentSet("duplicate number case", "1,1,2,3,4,5", "1,2,3,4,5,5")
        );
    }

    @ParameterizedTest
    @DisplayName("보너스 번호 입력 테스트")
    @MethodSource("makeBonusNumberException")
    void validateBonusNumber_Test(String input) {
        assertThatThrownBy(() -> InputValidator.validateLottoNumber(input))
                .isInstanceOf(Exception.class)
                .hasMessageContaining(ERROR_HEADER);
    }

    public static Stream<Arguments> makeBonusNumberException() {
        return Stream.of(
                Arguments.argumentSet("null and empty case", "", " ", "\n", null),
                Arguments.argumentSet("not in range case", "0", "55", "10000")
        );
    }
}