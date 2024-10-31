package lotto;

import lotto.domain.LottoGenerator;
import lotto.domain.LottoMachine;
import lotto.view.InputHandler;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        final InputView inputView = new InputView(new InputHandler());
        final OutputView outputView = new OutputView();
        final LottoGenerator lottoGenerator = new LottoGenerator();
        final LottoMachine lottoMachine = new LottoMachine(inputView, outputView, lottoGenerator);

        lottoMachine.run();
    }
}
