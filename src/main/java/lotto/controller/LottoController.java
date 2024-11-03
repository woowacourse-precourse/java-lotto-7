package lotto.controller;
import lotto.exceptions.LottoException;
import lotto.model.Lotto;
import lotto.model.LottoStatistics;
import lotto.services.LottoServices;
import lotto.view.ErrorView;
import lotto.view.InputViewer;
import lotto.view.OutputViewer;
import java.util.List;

public class LottoController {
    private final LottoServices services;
    private final InputViewer  inputViewer;
    private final OutputViewer outputViewer;
    private LottoStatistics statistics;

    private Lotto userLotto;
    private List<Lotto> randomLotteries;
    private int bonusNumber;

    public LottoController(LottoServices services, InputViewer inputViewer, OutputViewer outputViewer) {
        this.services = services;
        this.inputViewer = inputViewer;
        this.outputViewer = outputViewer;
    }

    public void start() {
        initLottoGame();
        printInitState();
        startLottoCheck();
        printLottoResult();
    }

    private void initLottoGame() {
        initStatistics();
        initRandomLotteries();
        initUserLotto();
    }

    private void initStatistics() {
        int amount = readValidPurchaseAmount();
        int quantity = amount / 1000;
        statistics = services.createLottoStatistics(amount, quantity);
    }

    private void initRandomLotteries() {
        randomLotteries = services.createRandomLotteries(statistics);
    }

    private void initUserLotto() {
        userLotto = services.createLotto(inputViewer.readUserLotto());
        bonusNumber = readValidBonusNumber();
    }

    private void printInitState() {
        outputViewer.printLottoInitSummary(statistics.toDTO(), randomLotteries);
    }

    private void startLottoCheck() {
        services.checkLottoResults(statistics, randomLotteries, userLotto, bonusNumber);
        services.checkLottoYield(statistics);
    }

    private void printLottoResult() {
        outputViewer.printLottoResult(statistics.toDTO());
    }

    private int readValidPurchaseAmount() {
        LottoValidator validator = new LottoValidator();
        while (true) {
            try {
                int amount = inputViewer.readPurchaseAmount();
                validator.isValidAmount(amount);
                return amount;
            } catch(LottoException e) {
                ErrorView.displayError(e);
            }
        }
    }

    private int readValidBonusNumber() {
        LottoValidator validator = new LottoValidator();
        while (true) {
            try {
                int bonusNumber = inputViewer.readBonusNumber();
                validator.isValidBonusNumber(bonusNumber);
                return bonusNumber;
            } catch(LottoException e) {
                ErrorView.displayError(e);
            }
        }
    }
}
