package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AmountTest {

    @Test
    @DisplayName("로또 구입 금액 - 공백")
    void blankPurchaseAmount() {
        assertThatThrownBy(() -> Amount.of(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.BLANK_PURCHASE_AMOUNT.getMessage());
    }

    @Test
    @DisplayName("로또 구입 금액 - 숫자가 아닌 문자")
    void notNumericPurchaseAmount() {
        assertThatThrownBy(() -> Amount.of("-"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_NUMERIC_PURCHASE_AMOUNT.getMessage());
    }

    @Test
    @DisplayName("로또 구입 금액 - 음수")
    void negativePurchaseAmount() {
        assertThatThrownBy(() -> Amount.of("-5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NEGATIVE_PURCHASE_AMOUNT.getMessage());
    }

    @Test
    @DisplayName("로또 구입 금액 - 너무 큰 숫자")
    void tooBigPurchaseAmount() {
        assertThatThrownBy(() -> Amount.of("1000000000000000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.TOO_BIG_PURCHASE_AMOUNT.getMessage());
    }

    @Test
    @DisplayName("로또 구입 금액 - 1,000원 이하")
    void underThousandPurchaseAmount() {
        assertThatThrownBy(() -> Amount.of("900"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.UNDER_THOUSAND_PURCHASE_AMOUNT.getMessage());
    }

    @Test
    @DisplayName("로또 구입 금액 - 1,000원 단위가 아닌 경우")
    void notThousandUnitPurchaseAmount() {
        assertThatThrownBy(() -> Amount.of("11111"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_THOUSAND_UNIT_PURCHASE_AMOUNT.getMessage());
    }

    @Test
    @DisplayName("로또 구입 금액 - 성공 테스트")
    void validPurchaseAmount() {
        //given
        String input = "10000";

        //when
        Amount amount = Amount.of(input);

        //then
        assertThat(amount.getAmount()).isEqualTo(10000);
    }
}