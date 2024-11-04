package lotto.controller;

import static lotto.util.LottoSplitter.split;

import lotto.domain.BonusNumber;
import lotto.domain.Budget;
import lotto.domain.LottoMaker;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private Budget budget;
    private WinningNumbers winningNumbers;
    private BonusNumber bonusNumber;
    private LottoMaker lottoMaker;
    private Lottos lottos;
    private LottoResult lottoResult;

    private void init() {
        buyLotto();
        setWinningLotto();
        setBonusNumber();
    }

    private void buyLotto() {
        while (true) {
            try {
                budget = new Budget(inputView.inputBudget());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        lottoMaker = new LottoMaker(budget);
        lottos = new Lottos(lottoMaker.getLottos());
        outputView.printPurchasedLottos(lottos);

    }

    private void setWinningLotto() {
        while (true) {
            try {
                winningNumbers = new WinningNumbers(split(inputView.
                        inputWinningNumber()));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void setBonusNumber () {
        while (true) {
            try {
                bonusNumber = new BonusNumber(inputView.inputBonusNumber(),
                        winningNumbers.getWinningNumbers());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void process() {
        lottoResult = new LottoResult(lottos, winningNumbers, budget, bonusNumber);
        outputView.printResult(lottoResult.getResult(), lottoResult.getRateOfReturn());
    }

    public void run() {
        init();
        process();
    }
}
