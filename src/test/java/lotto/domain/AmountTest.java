package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AmountTest {

    @Test
    @DisplayName("로또 구입 금액 - 공백")
    void blankPurchaseAmount() {
        //given
        String input = "";

        //when & then
        assertThatThrownBy(() -> Amount.of(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.BLANK_PURCHASE_AMOUNT.getMessage());
    }

    @Test
    @DisplayName("로또 구입 금액 - 숫자가 아닌 문자")
    void notNumericPurchaseAmount() {
        //given
        String input = "-";

        //when & then
        assertThatThrownBy(() -> Amount.of(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_NUMERIC_PURCHASE_AMOUNT.getMessage());
    }

    @Test
    @DisplayName("로또 구입 금액 - 음수")
    void negativePurchaseAmount() {
        //given
        String input = "-5";

        //when & then
        assertThatThrownBy(() -> Amount.of(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NEGATIVE_PURCHASE_AMOUNT.getMessage());
    }

    @Test
    @DisplayName("로또 구입 금액 - 너무 큰 숫자")
    void tooBigPurchaseAmount() {
        //given
        String input = "1000000000000000";

        //when & then
        assertThatThrownBy(() -> Amount.of(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.TOO_BIG_PURCHASE_AMOUNT.getMessage());
    }

    @Test
    @DisplayName("로또 구입 금액 - 1,000원 이하")
    void underThousandPurchaseAmount() {
        //given
        String input = "900";

        //when & then
        assertThatThrownBy(() -> Amount.of(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.UNDER_THOUSAND_PURCHASE_AMOUNT.getMessage());
    }

    @Test
    @DisplayName("로또 구입 금액 - 1,000원 단위가 아닌 경우")
    void notThousandUnitPurchaseAmount() {
        //given
        String input = "11111";

        //when & then
        assertThatThrownBy(() -> Amount.of(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_THOUSAND_UNIT_PURCHASE_AMOUNT.getMessage());
    }
}