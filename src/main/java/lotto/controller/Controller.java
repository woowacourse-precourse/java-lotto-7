package lotto.controller;

import java.util.List;
import lotto.model.Analyst;
import lotto.model.Calculator;
import lotto.model.Issuer;
import lotto.model.Lotties;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.LottoResults;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final Calculator calculator;
    private final Issuer issuer;
    private Lotties lotties;
    private LottoResults lottoResults;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.calculator = new Calculator();
        this.issuer = new Issuer();
    }

    public void runLottoTicketMachine() {
        int lottoCount = prepareLottoRelease();
        issueLotties(lottoCount);
        createLottoResults();
        printLottoResults();
    }

    private int prepareLottoRelease() {
        outputView.printInputMoneyPrompt();
        String cost = inputView.inputCost();
        return calculator.getLottoCount(cost);
    }

    private void issueLotties(int lottoCount) {
        this.lotties = issuer.issueLotties(lottoCount);
        outputView.printBoughtLottoCounts(lottoCount);
        outputView.printBoughtLottoNumbers(lotties);
    }

    private void createLottoResults() {
        Lotto winningLotto = inputWinningLottoNumbers();
        int bonusNumber = inputBonusNumber();
        this.lottoResults = new LottoResults(winningLotto, bonusNumber);
    }

    private Lotto inputWinningLottoNumbers() {
        outputView.printInputWinningNumbersPrompt();
        return inputView.inputWinningLottoNumbers();
    }

    private int inputBonusNumber() {
        outputView.printInputBonusNumbersPrompt();
        return inputView.bonusWinningLottoNumber();
    }

    private void printLottoResults() {
        List<LottoResult> lottoResultsList = lottoResults.getLottoResults(lotties);
        Analyst analyst = new Analyst(lottoResultsList, lotties.getCost());
        outputView.printWinningStatics(analyst);
    }
}
