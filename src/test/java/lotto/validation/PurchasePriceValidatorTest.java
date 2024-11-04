package lotto.validation;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.constatnt.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PurchasePriceValidatorTest extends NsTest {

    @DisplayName("로또 구입 금액이 공백일 때 예외 처리 후 재입력 요청")
    @ParameterizedTest
    @ValueSource(strings = {" "})
    void shouldDisplayErrorMessageAndRequestInputWhenBlank(String input) {
        assertSimpleTest(() -> {
            runException(input);
            assertThat(output()).contains(ExceptionMessage.PURCHASE_PRICE_BLANK_INPUT.getMessage());
        });
    }

    @DisplayName("로또 구입 금액이 음수일 때 예외 처리")
    @Test
    void shouldDisplayErrorMessageForInvalidInput() {
        assertSimpleTest(() -> {
            runException("-4000");
            assertThat(output()).contains(ExceptionMessage.PURCHASE_PRICE_NOT_POSITIVE_NUMBER.getMessage());
        });
    }

    @DisplayName("로또 구입 금액이 0일 때 예외 처리")
    @Test
    void shouldThrowExceptionWhenPurchasePriceIsZero() {
        assertSimpleTest(() -> {
            runException("0");
            assertThat(output()).contains(ExceptionMessage.PURCHASE_PRICE_NOT_POSITIVE_NUMBER.getMessage());
        });
    }

    @DisplayName("로또 구입 금액이 1000으로 나누어 떨어지지 않을 때 예외 처리")
    @Test
    void shouldThrowExceptionWhenPurchasePriceIsNotMultipleOfThousand() {
        assertSimpleTest(() -> {
            runException("12345");
            assertThat(output()).contains(ExceptionMessage.PURCHASE_PRICE_NOT_MULTIPLE_OF_THOUSAND.getMessage());
        });
    }

    @DisplayName("로또 구입 금액이 1억원 이상일 때 예외 처리")
    @Test
    void shouldThrowExceptionWhenPurchasePriceExceedsLimit() {
        assertSimpleTest(() -> {
            runException("999999000");
            assertThat(output()).contains(ExceptionMessage.PURCHASE_PRICE_UPPER_LIMIT.getMessage());
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
