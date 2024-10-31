package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.controller.ErrorMessages;
import lotto.service.LottoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {

    private static final int PRICE_OF_LOTTO_TICKET = 1000;

    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        this.lottoService = new LottoService();
    }

    @Test
    @DisplayName("잘못된 단위로 구매 가격을 입력할 경우 예외를 던진다.")
    void throwExceptionWhenPaidAmountHasInvalidUnit() {
        // given
        int invalidUnitInput = PRICE_OF_LOTTO_TICKET + 1;

        // when & then
        assertThatThrownBy(() -> lottoService.purchase(invalidUnitInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.INVALID_UNIT_OF_PAID_AMOUNT);
    }
}
