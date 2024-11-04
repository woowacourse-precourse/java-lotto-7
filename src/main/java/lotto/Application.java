package lotto;

import lotto.presentation.LottoController;
import lotto.view.OutputErrorView;

public class Application {

  public static void main(String[] args) {
    LottoController lottoController = new LottoController();

    try {
      lottoController.run();
    } catch (IllegalArgumentException e) {
      OutputErrorView.printError(e);
    }
  }
}
