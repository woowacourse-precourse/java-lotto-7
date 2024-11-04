package lotto.controller;

import lotto.model.Analyst;
import lotto.model.Calculator;
import lotto.model.Issuer;
import lotto.model.Lotto;
import lotto.model.LottoResults;
import lotto.model.Lottos;
import lotto.model.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final Calculator calculator;
    private final Issuer issuer;
    private Lottos lottos;
    private WinningNumbers winningNumbers;
    private LottoResults lottoResults;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.calculator = Calculator.getInstance();
        this.issuer = new Issuer();
    }

    public void runLottoTicketMachine() {
        int lottoTicketCount = prepareLottoRelease();
        issueLottos(lottoTicketCount);
        createLottoResults();
        printLottoResults();
    }

    private int prepareLottoRelease() {
        while (true) {
            try {
                outputView.printInputTicketCountPrompt();
                String purchaseAmount = inputView.inputPurchaseAmount();
                return calculator.getLottoCount(purchaseAmount);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void issueLottos(int lottoTicketCount) {
        while (true) {
            try {
                this.lottos = issuer.issueLottos(lottoTicketCount);
                outputView.printBoughtLottoTicketCount(lottoTicketCount);
                outputView.printBoughtLottos(lottos);
                return;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
                lottoTicketCount = prepareLottoRelease();
            }
        }
    }

    private void createLottoResults() {
        Lotto winningLotto;
        int bonusNumber;
        while (true) {
            winningLotto = getInputWinningLottoNumbers();
            bonusNumber = getInputBonusNumber();
            try {
                winningNumbers = new WinningNumbers(winningLotto, bonusNumber);
                this.lottoResults = new LottoResults(winningNumbers);
                return;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private Lotto getInputWinningLottoNumbers() {
        while (true) {
            try {
                outputView.printInputWinningNumbersPrompt();
                return inputView.inputWinningLottoNumbers();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private int getInputBonusNumber() {
        while (true) {
            try {
                outputView.printInputBonusNumberPrompt();
                return inputView.bonusWinningLottoNumber();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void printLottoResults() {
        lottoResults.initLottoResults(lottos);
        Analyst analyst = Analyst.getInstance();
        outputView.printLottoResults(analyst.calculateWinLottoCount(lottoResults.getLottoResults()));
        outputView.printLottoStatics(analyst.calculateYield(lottoResults.getLottoResults()));
    }
}