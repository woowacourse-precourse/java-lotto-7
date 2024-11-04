package lotto;

import lotto.domain.LottoGenerator;
import lotto.ui.InputController;
import lotto.ui.OutputController;
import lotto.ui.Repeater;
import lotto.ui.UiInitializer;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        final OutputController outputController = UiInitializer.initOutputController();
        final InputController inputController = UiInitializer.initInputController();
        final Repeater repeater = new Repeater(outputController);
        final LottoGenerator lottoGenerator = new LottoGenerator();

        final LottoGame lottoGame = new LottoGame(inputController, outputController, repeater, lottoGenerator);

        lottoGame.run();
    }
}
