package lotto.core.service;

import lotto.core.dto.LottoPurchaseAmountDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CreateLottoPurchaseAmountServiceTest {

    private CreateLottoPurchaseAmountService service;

    @BeforeEach
    void setUp() {
        service = new CreateLottoPurchaseAmountService();
    }

    @Test
    void create_should_be_pass() {
        // given
        String value = "10000";
        // when
        LottoPurchaseAmountDto result = service.create(value);
        // then
        Assertions.assertEquals(10000, result.value());
        Assertions.assertEquals(10, result.lottoCount());
    }
}
