package lotto.service;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.enums.ErrorCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ValidatorServiceTest {

    private ValidatorService validatorService;

    @BeforeEach
    void setUp() {
        validatorService = new ValidatorService();
    }

    @Test
    void 구매_금액_검증_유효한_금액() {
        int validAmount = 5000;
        assertThatCode(() -> validatorService.validatePurchaseAmount(validAmount))
                .doesNotThrowAnyException();
    }

    @Test
    void 구매_금액_검증_유효하지_않은_금액() {
        int invalidAmount = 5500;
        assertThatThrownBy(() -> validatorService.validatePurchaseAmount(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.INVALID_PURCHASE_AMOUNT.getMessage());
    }
}
