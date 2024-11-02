package lotto.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.controller.ErrorMessages;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoSalesServiceTest {

    private static final int PRICE_OF_LOTTO_TICKET = 1000;

    private LottoSalesService lottoSalesService;

    @BeforeEach
    void setUp() {
        this.lottoSalesService = new LottoSalesService();
    }

    @Test
    @DisplayName("잘못된 단위로 구매 가격을 입력할 경우 예외를 던진다.")
    void throwExceptionWhenPaidAmountHasInvalidUnit() {
        // given
        int invalidUnitInput = PRICE_OF_LOTTO_TICKET + 1;

        // when & then
        assertThatThrownBy(() -> lottoSalesService.sellLottoToNewCustomer(invalidUnitInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.INVALID_UNIT_OF_PAID_AMOUNT);
    }
}
