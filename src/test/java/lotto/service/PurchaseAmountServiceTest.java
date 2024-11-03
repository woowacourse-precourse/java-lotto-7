package lotto.service;

import lotto.model.LotteryMachineModel;
import lotto.parse.InputParser;
import lotto.validation.InputValidator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseAmountServiceTest {

    private PurchaseAmountService purchaseAmountService;

    @BeforeEach
    void init() {
        InputValidator inputValidator = new InputValidator();
        InputParser inputParser = new InputParser();
        LotteryMachineModel lotteryMachineModel = new LotteryMachineModel();
        this.purchaseAmountService = new PurchaseAmountService(inputValidator, inputParser, lotteryMachineModel);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000", "10000000000000000"})
    void save_처리_로직이_정상_작동한다(String purchaseAmountInput) {
        // given

        // when

        // then
        Assertions.assertThatCode(() -> purchaseAmountService.save(purchaseAmountInput))
                .doesNotThrowAnyException();
    }
}