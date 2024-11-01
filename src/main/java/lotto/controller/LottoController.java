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
    private final ErrorView view;
    private final LottoServices services;
    private LottoStatistics statistics;
    private Lotto userLotto;
    private List<Lotto> randomLotteries;
    private int bonusNumber;

    public LottoController(ErrorView view, LottoServices services) {
        this.view = view;
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
        printInitState();
    }

    private void initUserLotto() {
        userLotto = services.createLotto(InputView.readUserLotto());
        bonusNumber = readValidBonusNumber();
    }

    private void printInitState() {
        OutputView.displayLottoCount(statistics.toDTO());
        OutputView.displayLottos(randomLotteries);
    }

    private void startLottoCheck() {
        services.checkLottoResults(statistics, randomLotteries, userLotto, bonusNumber);
        services.checkLottoYield(statistics);
    }

    private void printLottoResult() {
        OutputView.printLottoResult(statistics);
    }

    public int readValidPurchaseAmount() {
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

    public int readValidBonusNumber() {
        LottoValidator validator = new LottoValidator();
        while (true) {
            try {
                int bonusNumber = InputView.readBonusNumber();
                validator.isValidBounusNumber(bonusNumber);
                return bonusNumber;
            } catch(LottoException e) {
                ErrorView.displayError(e);
            }
        }
    }
}
