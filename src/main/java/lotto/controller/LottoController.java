package lotto.controller;
import lotto.model.Lotto;
import lotto.model.LottoStatistics;
import lotto.services.LottoServices;
import lotto.view.LottoView;
import java.util.List;

public class LottoController {
    private final LottoView view;
    private final LottoServices services;
    private LottoStatistics statistics;
    private Lotto userLotto;
    private List<Lotto> randomLotteries;
    private int bonusNumber;

    public LottoController(LottoView view, LottoServices services) {
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
        userLotto = services.createLotto(view.readUserLotto());
        bonusNumber = readValidBonusNumber();
    }

    private void printInitState() {
        view.displayLottoCount(statistics.toDTO());
        view.displayLottos(randomLotteries);
    }

    private void startLottoCheck() {
        services.checkLottoResults(statistics, randomLotteries, userLotto, bonusNumber);
        services.checkLottoYield(statistics);
    }

    private void printLottoResult() {
        view.printLottoResult(statistics);
    }

    public int readValidPurchaseAmount() {
        LottoValidator validator = new LottoValidator();
        while (true) {
            try {
                int amount = view.readPurchaseAmount();
                validator.isValidAmount(amount);
                return amount;
            } catch(IllegalArgumentException e) {
                view.displayError(e.getMessage());
            }
        }
    }

    public int readValidBonusNumber() {
        LottoValidator validator = new LottoValidator();
        while (true) {
            try {
                int bonusNumber = view.readBonusNumber();
                validator.isValidBounusNumber(bonusNumber);
                return bonusNumber;
            } catch(IllegalArgumentException e) {
                view.displayError(e.getMessage());
            }
        }
    }
}
