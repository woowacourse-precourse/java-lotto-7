package lotto.service;

import lotto.model.LotteryMachineModel;
import lotto.parse.InputParser;
import lotto.validation.InputValidator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PurchaseAmountServiceTest {

    private PurchaseAmountService purchaseAmountService;

    @BeforeEach
    void init() {
        InputValidator inputValidator = new InputValidator();
        InputParser inputParser = new InputParser();
        LotteryMachineModel lotteryMachineModel = new LotteryMachineModel();
        this.purchaseAmountService = new PurchaseAmountService(inputValidator, inputParser, lotteryMachineModel);
    }

    @Test
    void save_처리_로직이_정상_작동한다() {
        // given
        String purchaseAmountInput = "10000";

        // when

        // then
        Assertions.assertThatCode(() -> purchaseAmountService.save(purchaseAmountInput))
                .doesNotThrowAnyException();
    }
}