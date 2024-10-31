package lotto.lotto;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.CustomException;
import lotto.exception.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberTest {

    @DisplayName("로또 번호가 1~45의 수라면 예외가 발생하지 않는다..")
    @ValueSource(ints = {1, 10, 43, 45})
    @ParameterizedTest
    void newNumberWithValidNumber(int validNumber) {
        // when & then
        assertThatCode(() -> new Number(validNumber))
                .doesNotThrowAnyException();
    }

    @DisplayName("로또 번호가 1~45의 수가 아니라면 예외가 발생한다.")
    @ValueSource(ints = {-1, 0, 46, 100})
    @ParameterizedTest
    void newNumberWithOutInvalidNumber(int invalidNumber) {
        // when & then
        assertThatThrownBy(() -> new Number(invalidNumber))
                .isInstanceOf(CustomException.class)
                .hasMessage("[ERROR] " + ExceptionMessage.INVALID_LOTTO_NUMBER_EXCEPTION.getMessage());
    }
}