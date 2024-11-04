package lotto;


import lotto.controller.LottoManager;
import lotto.service.LottoCalculator;
import lotto.service.LottoEvaluator;
import lotto.service.LottoMachine;
import lotto.view.InputHandler;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {

  public static void main(String[] args) {
    OutputView outputView = new OutputView();
    LottoMachine lottoMachine = new LottoMachine();
    LottoCalculator lottoCalculator = new LottoCalculator();
    LottoEvaluator lottoEvaluator = new LottoEvaluator();
    InputHandler inputHandler = new InputHandler(new InputView());
    LottoManager lottoManager = new LottoManager(outputView, lottoMachine, lottoCalculator,
        lottoEvaluator, inputHandler);
    lottoManager.run();
  }
}
