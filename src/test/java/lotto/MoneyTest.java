package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.MoneyExceptionType;
import lotto.service.LottoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {
    private final LottoService lottoService = new LottoService();

    @ParameterizedTest
    @DisplayName("입력이 비었으면 예외가 발생한다")
    @ValueSource(strings = {"", " "})
    void exception_empty_input_money(String money) {
        assertThatThrownBy(() -> lottoService.checkAndConvertInputMoney(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MoneyExceptionType.EMPTY_INPUT_MONEY.getMessage());
    }

    @ParameterizedTest
    @DisplayName("1000 ~ 100000의 사이의 정수가 아니면 예외가 발생한다")
    @ValueSource(strings = {"500", "999999"})
    void exception_out_of_range_money(String money) {
        assertThatThrownBy(() -> lottoService.checkAndConvertInputMoney(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MoneyExceptionType.OUT_OF_RANGE_MONEY.getMessage());
    }

    @Test
    @DisplayName("구입 금액이 1,000원으로 나누어 떨어지지 않으면 예외가 발생한다")
    void exception_non_divisible_money() {
        assertThatThrownBy(() -> lottoService.checkAndConvertInputMoney("1234"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MoneyExceptionType.NON_DIVISIBLE_MONEY.getMessage());
    }

    @ParameterizedTest
    @DisplayName("입력이 숫자가 아니면 예외가 발생한다")
    @ValueSource(strings = {"1000.0, 1000원"})
    void exception_not_integer_money(String money) {
        assertThatThrownBy(() -> lottoService.checkAndConvertInputMoney(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MoneyExceptionType.NOT_INTEGER_MONEY.getMessage());
    }
}