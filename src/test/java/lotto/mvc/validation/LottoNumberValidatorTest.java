package lotto.mvc.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberValidatorTest {

    @DisplayName("예외 - 공백을 입력한 경우")
    @ParameterizedTest
    @NullAndEmptySource
    void test1(String input) {
        IllegalArgumentException e = assertThrowsExactly(IllegalArgumentException.class, () -> {
            LottoNumberValidator.isValid(input);
        });

        assertEquals("[ERROR] 로또 구매 금액을 입력하셔야 합니다.", e.getMessage());
    }

    @DisplayName("예외 - 문자를 입력한 경우")
    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, a", "1,2,3,,,5,6", "11.234"})
    void test2(String input) {
        IllegalArgumentException e = assertThrowsExactly(IllegalArgumentException.class, () -> {
            LottoNumberValidator.isValid(input);
        });

        assertEquals("[ERROR] 로또 구매 금액은 숫자로 입력하셔야 합니다.", e.getMessage());
    }

    @DisplayName("예외 - 음수를 입력한 경우")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "-10", "-111111111111", "-2147483647000", "-9223372036854775807"})
    void test3(String input) {
        IllegalArgumentException e = assertThrowsExactly(IllegalArgumentException.class, () -> {
            LottoNumberValidator.isValid(input);
        });

        assertEquals("[ERROR] 로또 구매 금액은 양의 정수로 입력하셔야 합니다.", e.getMessage());
    }

    @DisplayName("예외 - 0를 입력한 경우")
    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 0, 5, 6, 7"})
    void test4(String input) {
        IllegalArgumentException e = assertThrowsExactly(IllegalArgumentException.class, () -> {
            LottoNumberValidator.isValid(input);
        });

        assertEquals("[ERROR] 로또 구매 금액은 양의 정수로 입력하셔야 합니다.", e.getMessage());
    }

    @DisplayName("예외 - 제한 범위를 초과한 경우")
    @ParameterizedTest
    @ValueSource(strings = {"2147483647001", "2147483647002", "9223372036854775809"})
    void test5(String input) {
        IllegalArgumentException e = assertThrowsExactly(IllegalArgumentException.class, () -> {
            LottoNumberValidator.isValid(input);
        });

        assertEquals("[ERROR] 로또 구매 금액은 " + (long) Integer.MAX_VALUE * 1000 + "를 초과할 수 없습니다.", e.getMessage());
    }

    @DisplayName("예외 - 로또 1장 구매 단위로 입력하지 않은 경우")
    @ParameterizedTest
    @ValueSource(strings = {"11001", "22001", "9999"})
    void test6(String input) {
        IllegalArgumentException e = assertThrowsExactly(IllegalArgumentException.class, () -> {
            LottoNumberValidator.isValid(input);
        });

        assertEquals("[ERROR] 로또 구매 금액은 " + 1000 + "원 단위로 입력하셔야 합니다.", e.getMessage());
    }
}