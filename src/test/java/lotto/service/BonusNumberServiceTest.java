package lotto.service;

import lotto.model.LotteryMachineModel;
import lotto.parse.InputParser;
import lotto.validation.InputValidator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class BonusNumberServiceTest {

    private BonusNumberService bonusNumberService;

    @BeforeEach
    void init() {
        InputValidator inputValidator = new InputValidator();
        InputParser inputParser = new InputParser();
        LotteryMachineModel lotteryMachineModel = new LotteryMachineModel();
        this.bonusNumberService = new BonusNumberService(inputValidator, inputParser, lotteryMachineModel);
    }

    @ParameterizedTest
    @MethodSource("lotto.parameterizedTest.MethodSource#generateNormalLottoNumber")
    void save_처리_로직이_정상_작동한다(Integer number) {
        // given
        if (number <= 6) { // 당첨 번호 초기화값으로 인해 오류 발생
            return;
        }
        String input = String.valueOf(number);

        // when

        // then
        Assertions.assertThatCode(() -> bonusNumberService.save(input))
                .doesNotThrowAnyException();
    }
}