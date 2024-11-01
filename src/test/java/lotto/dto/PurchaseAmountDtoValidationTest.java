package lotto.dto;

import lotto.exception.LottoExceptionStatus;
import lotto.properties.LottoProperties;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class PurchaseAmountDtoValidationTest {

    @Test
    @DisplayName("올바른 구매 금액으로 Dto 생성")
    void validPurchaseAmount() {
        // given
        int validAmount = LottoProperties.LOTTO_PRICE * 5;

        // when
        PurchaseAmountDto purchaseAmountDto = new PurchaseAmountDto(validAmount);

        // then
        assertThat(purchaseAmountDto.purchaseAmount()).isEqualTo(validAmount);
    }

    @Test
    @DisplayName("천원 단위가 아닌 구매 금액으로 Dto 생성 시 예외 발생")
    void invalidPurchaseAmount_shouldThrowException() {
        // given
        int invalidAmount = LottoProperties.LOTTO_PRICE * 5 + 500;

        // when & then
        assertThatThrownBy(() -> new PurchaseAmountDto(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoExceptionStatus.INVALID_LOTTO_PURCHASE_AMOUNT.getMessage());
    }

}
