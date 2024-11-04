package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoManager;
import lotto.model.LottoResultCalculator;
import lotto.model.Lottos;
import lotto.model.Ranking;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoConsole {

  private final LottoResultCalculator lottoResultCalculator;
  private final InputView inputView;
  private final OutputView outputView;
  private Lottos lottos;
  private LottoManager lottoManager;
  private Map<Ranking, Integer> result;

  public LottoConsole() {
    this.lottoResultCalculator = new LottoResultCalculator();
    this.inputView = new InputView();
    this.outputView = new OutputView();
  }

  public void run() {
    proccessLottoArea();
    proccessResultArea();
    displayEarningRate();
  }

  private void proccessLottoArea() {
    lottoManager = createValidLotto();
    lottos = lottoManager.generateLottos();
    outputView.printLottoSize(lottos.size());
    for (Lotto lotto : lottos.lottos()) {
      outputView.printLottos(lotto.getNumbers());
    }
  }

  private LottoManager createValidLotto() {
    try {
      int price = inputView.inputPrice();
      return new LottoManager(price);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      return createValidLotto();
    }
  }

  private void proccessResultArea() {
    List<Integer> winningNumbers = createValidWinningLottoNumbers();
    int bonus = inputBonusAfterChecking(winningNumbers);
    Lotto winningLotto = new Lotto(winningNumbers, bonus);
    result = lottoResultCalculator.getResultStorage(winningLotto, lottos, bonus);
    outputView.printResult();
    for (int i = Ranking.values().length - 1; i >= 0; i--) {
      if (!(Ranking.values()[i] == Ranking.NONE)) {
        outputView.printWinningStatistics(Ranking.values()[i].getMessage(), result.get(Ranking.values()[i]));
      }
    }
  }

  private List<Integer> createValidWinningLottoNumbers() {
    try {
      List<Integer> winningNumbers = inputView.inputWinningNumbers();
      Lotto lotto = new Lotto(winningNumbers);
      return lotto.getNumbers();
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      return createValidWinningLottoNumbers();
    }
  }

  private int inputBonusAfterChecking(List<Integer> winningNumbers) {
    try {
      int bonus = inputView.inputBonusNumber();
      new Lotto(winningNumbers, bonus);
      return bonus;
    } catch (IllegalArgumentException e) {
      System.out.print(e.getMessage());
      return inputBonusAfterChecking(winningNumbers);
    }
  }

  private void displayEarningRate() {
    int totalWinPrice = result.keySet().stream()
            .mapToInt(ranking -> result.get(ranking) * ranking.getWinPrice())
            .sum();
    outputView.printEarningRate(
            lottoResultCalculator.calculateTotalEarningRate(lottoManager.getPrice(), totalWinPrice));
  }
}