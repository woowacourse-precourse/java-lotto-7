package lotto.service;

import lotto.model.LotteryMachineModel;
import lotto.parse.InputParser;
import lotto.validation.InputValidator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WinnerNumberServiceTest {

    private WinnerNumberService winnerNumberService;

    @BeforeEach
    void init() {
        InputValidator inputValidator = new InputValidator();
        InputParser inputParser = new InputParser();
        LotteryMachineModel lotteryMachineModel = new LotteryMachineModel();
        this.winnerNumberService = new WinnerNumberService(inputValidator, inputParser, lotteryMachineModel);
    }

    @Test
    void save_처리_로직이_정상_작동한다() {
        // given
        String winnerNumbersInput = "1,20,2,4,35,34";

        // when

        // then
        Assertions.assertThatCode(() -> winnerNumberService.save(winnerNumbersInput))
                .doesNotThrowAnyException();
    }
}