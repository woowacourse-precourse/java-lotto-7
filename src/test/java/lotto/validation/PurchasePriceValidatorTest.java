package lotto.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.constatnt.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class PurchasePriceValidatorTest extends NsTest {

    @DisplayName("로또 구입 금액이 공백일 때 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {" "})
    void shouldThrowExceptionWhenPurchasePriceIsBlank(String input) {
        assertThatThrownBy(() -> runException(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.PURCHASE_PRICE_BLANK_INPUT.getMessage());
    }

    @DisplayName("로또 구입 금액이 음수일 때 예외 처리")
    @Test
    void shouldThrowExceptionWhenPurchasePriceIsNegative() {
        assertThatThrownBy(() -> runException("-4000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 구입 금액은 양수를 입력해주세요.");
    }

    @DisplayName("로또 구입 금액이 0일 때 예외 처리")
    @Test
    void shouldThrowExceptionWhenPurchasePriceIsZero() {
        assertThatThrownBy(() -> runException("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 구입 금액은 양수를 입력해주세요.");
    }

    @DisplayName("로또 구입 금액이 1000으로 나누어 떨어지지 않을 때 예외 처리")
    @Test
    void shouldThrowExceptionWhenPurchasePriceIsNotMultipleOfThousand() {
        assertThatThrownBy(() -> runException("12345"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 구입 금액은 1000단위로 입력해야 합니다.");
    }

    @DisplayName("로또 구입 금액이 1억원 이상일 때 예외 처리")
    @Test
    void shouldThrowExceptionWhenPurchasePriceExceedsLimit() {
        assertThatThrownBy(() -> runException("999999000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 구입 금액은 1억 미만이어야 합니다.");
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
