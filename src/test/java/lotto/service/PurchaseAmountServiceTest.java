package lotto.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constant.ExceptionMessage;
import lotto.parse.InputParser;
import lotto.validation.InputValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PurchaseAmountServiceTest {

    private PurchaseAmountService purchaseAmountService;

    @BeforeEach
    void init() {
        InputValidator inputValidator = new InputValidator();
        InputParser inputParser = new InputParser();
        this.purchaseAmountService = new PurchaseAmountService(inputValidator, inputParser);
    }

    @Test
    void processPurchaseAmount_처리_로직이_정상_작동한다() {
        // given
        String purchaseAmountInput = "10000";

        // when
        purchaseAmountService.processPurchaseAmount(purchaseAmountInput);

        // then
    }

    @Test
    void validateNonThousandDivisibility_1000_으로_나누어떨어진다() {
        // given
        Long number = 5000L;

        // when
        purchaseAmountService.validateNonThousandDivisibility(number);

        // then
    }

    @Test
    void validateNonThousandDivisibility_1000_으로_나누어떨어지지_않는다() {
        // given
        Long number = 5500L;

        // when
        // then
        assertThatThrownBy(() -> purchaseAmountService.validateNonThousandDivisibility(number))
                .isInstanceOf(IllegalArgumentException.class)
                .extracting(e -> e.getMessage())
                .isEqualTo(ExceptionMessage.PURCHASE_AMOUNT_THOUSAND_DIVISIBILITY);

    }
}