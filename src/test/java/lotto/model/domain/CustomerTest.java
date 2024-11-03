package lotto.model.domain;

import static lotto.message.ErrorMessage.INVALID_PAYMENT_AMOUNT;
import static lotto.message.ErrorMessage.INVALID_PAYMENT_FORMAT;
import static lotto.message.ErrorMessage.PAYMENT_IS_BLANK;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomerTest {

    @DisplayName("입력이 빈 문자열일 경우 예외가 발생한다.")
    @Test
    void 입력이_빈_문자열일_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new Customer(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PAYMENT_IS_BLANK.getMessage());
    }

    @DisplayName("입력이 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void 입력이_숫자가_아닐_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new Customer("abc123"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_PAYMENT_FORMAT.getMessage());
    }

    @DisplayName("입력이 1,000원 단위가 아닐 경우 예외가 발생한다.")
    @Test
    void 입력이_1_000원_단위가_아닐_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new Customer("1500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_PAYMENT_AMOUNT.getMessage());
    }
}
