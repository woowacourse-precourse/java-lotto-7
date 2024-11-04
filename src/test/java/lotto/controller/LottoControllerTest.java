package lotto.controller;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.InputType;
import lotto.model.LottoGame;
import lotto.view.InputView;
import lotto.view.OutputView;
import org.junit.jupiter.api.Test;

class LottoControllerTest {

    @Test
    void purchaseTest() {
        //given
        InputView overideInputView = new InputView() {
            @Override
            public String getInput(InputType inputType) {
                printMessage(inputType);
                return "5000"; // 테스트용 하드코딩된 입력
            }
        };
        LottoGame game = new LottoGame();
        LottoController controller = new LottoController(game, overideInputView, new OutputView());
        //when
        controller.purchase();
        controller.displayLottos();
        //then
        assertThat(game.getLottos().size()).isEqualTo(5);
    }
}
