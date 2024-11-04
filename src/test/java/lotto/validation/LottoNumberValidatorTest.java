package lotto.validation;

import static lotto.util.Constants.ERROR_CONTAIN_LETTER_MSG;
import static lotto.util.Constants.ERROR_EXCEED_LOTTO_END_NUMBER_MSG;
import static lotto.util.Constants.ERROR_IS_UNDER_LOTTO_START_NUMBER_MSG;
import static lotto.util.Constants.ERROR_IS_VACANT_MSG;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("로또 당첨 번호 입력에 대한 검증")
class LottoNumberValidatorTest {

    @DisplayName("예외 - 공백을 입력한 경우")
    @ParameterizedTest
    @NullAndEmptySource
    void test1(String input) {
        Assertions.assertThatThrownBy(() -> LottoNumberValidator.isValid(input))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("[ERROR]", ERROR_IS_VACANT_MSG);
    }

    @DisplayName("예외 - 문자를 입력한 경우")
    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, a", "1,2,3,,,5,6", "11.2347"})
    void test2(String input) {
        Assertions.assertThatThrownBy(() -> LottoNumberValidator.isValid(input))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("[ERROR]", ERROR_CONTAIN_LETTER_MSG);
    }

    @DisplayName("예외 - 음수를 입력한 경우")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,-15,7,24", "-10,1, 2, 3, 4, 5"})
    void test3(String input) {
        Assertions.assertThatThrownBy(() -> LottoNumberValidator.isValid(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]", ERROR_IS_UNDER_LOTTO_START_NUMBER_MSG);
    }

    @DisplayName("예외 - 0를 입력한 경우")
    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 0, 5, 6, 7"})
    void test4(String input) {
        Assertions.assertThatThrownBy(() -> LottoNumberValidator.isValid(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]", ERROR_IS_UNDER_LOTTO_START_NUMBER_MSG);
    }

    @DisplayName("예외 - int 범위를 초과한 경우")
    @ParameterizedTest
    @ValueSource(strings = {"2147483647001", "2147483647002", "9223372036854775809"})
    void test5(String input) {
        Assertions.assertThatThrownBy(() -> LottoNumberValidator.isValid(input))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("[ERROR]", ERROR_CONTAIN_LETTER_MSG);
    }

    @DisplayName("예외 - 45를 초과하는 경우")
    @ParameterizedTest
    @ValueSource(strings = {"46", "90", "66"})
    void test6(String input) {
        Assertions.assertThatThrownBy(() -> LottoNumberValidator.isValid(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]", ERROR_EXCEED_LOTTO_END_NUMBER_MSG);
    }

    @DisplayName("예외 - 중복된 번호를 입력한 경우")
    @ParameterizedTest
    @ValueSource(strings = {"1,1,2,3,4,5", "2,3,4,5,5,5", "12,14,16,44,44,45"})
    void test7(String input) {
        Assertions.assertThatThrownBy(() -> LottoNumberValidator.isValid(input))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("[ERROR]");
    }
}