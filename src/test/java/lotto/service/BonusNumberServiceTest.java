package lotto.service;

import lotto.model.LotteryMachineModel;
import lotto.parse.InputParser;
import lotto.validation.InputValidator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BonusNumberServiceTest {

    private BonusNumberService bonusNumberService;

    @BeforeEach
    void init() {
        InputValidator inputValidator = new InputValidator();
        InputParser inputParser = new InputParser();
        LotteryMachineModel lotteryMachineModel = new LotteryMachineModel();
        this.bonusNumberService = new BonusNumberService(inputValidator, inputParser, lotteryMachineModel);
    }

    @Test
    void save_처리_로직이_정상_작동한다() {
        // given
        String input = "40";

        // when

        // then
        Assertions.assertThatCode(() -> bonusNumberService.save(input))
                .doesNotThrowAnyException();
    }
}