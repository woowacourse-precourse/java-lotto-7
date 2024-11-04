package lotto.model.domain;

import static lotto.message.ErrorMessage.INVALID_PAYMENT_AMOUNT;
import static lotto.message.ErrorMessage.INVALID_PAYMENT_FORMAT;
import static lotto.message.ErrorMessage.INVALID_PAYMENT_LIMIT;
import static lotto.message.ErrorMessage.PAYMENT_IS_BLANK;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CustomerTest {

    @DisplayName("입력이 빈 문자열일 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = { "" })
    void 입력이_빈_문자열일_경우_예외가_발생한다(String input) {
        assertThatThrownBy(() -> new Customer(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PAYMENT_IS_BLANK.getMessage());
    }

    @DisplayName("입력이 숫자가 아닐 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = { "abc123", "abcd", "#$%" })
    void 입력이_숫자가_아닐_경우_예외가_발생한다(String input) {
        assertThatThrownBy(() -> new Customer(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_PAYMENT_FORMAT.getMessage());
    }

    @DisplayName("입력이 1,000원 단위가 아닐 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = { "1500", "250", "999" })
    void 입력이_1_000원_단위가_아닐_경우_예외가_발생한다(String input) {
        assertThatThrownBy(() -> new Customer(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_PAYMENT_AMOUNT.getMessage());
    }

    @DisplayName("입력이 10만원을 초과할 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = { "100001" })
    void 입력이_10만원을_초과할_경우_예외가_발생한다(String input) {
        assertThatThrownBy(() -> new Customer(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_PAYMENT_LIMIT.getMessage());
    }
}
