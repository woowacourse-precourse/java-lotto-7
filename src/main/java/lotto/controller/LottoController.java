package lotto.controller;
import lotto.exceptions.LottoException;
import lotto.model.Lotto;
import lotto.model.LottoStatistics;
import lotto.services.LottoServices;
import lotto.view.InputView;
import lotto.view.ErrorView;
import lotto.view.OutputView;
import java.util.List;

public class LottoController {
    private final LottoServices services;
    private LottoStatistics statistics;
    private Lotto userLotto;
    private List<Lotto> randomLotteries;
    private int bonusNumber;

    public LottoController(LottoServices services) {
        this.services = services;
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
        userLotto = services.createLotto(InputView.readUserLotto());
        bonusNumber = readValidBonusNumber();
    }

    private void printInitState() {
        OutputView.printLottoInitSummary(statistics.toDTO(), randomLotteries);
    }

    private void startLottoCheck() {
        services.checkLottoResults(statistics, randomLotteries, userLotto, bonusNumber);
        services.checkLottoYield(statistics);
    }

    private void printLottoResult() {
        OutputView.printLottoResult(statistics);
    }

    private int readValidPurchaseAmount() {
        LottoValidator validator = new LottoValidator();
        while (true) {
            try {
                int amount = InputView.readPurchaseAmount();
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
                int bonusNumber = InputView.readBonusNumber();
                validator.isValidBonusNumber(bonusNumber);
                return bonusNumber;
            } catch(LottoException e) {
                ErrorView.displayError(e);
            }
        }
    }
}
