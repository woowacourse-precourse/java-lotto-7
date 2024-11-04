package lotto.controller;
import lotto.exceptions.LottoException;
import lotto.exceptions.LottoNumberFormatException;
import lotto.model.Lotto;
import lotto.model.LottoStatistics;
import lotto.services.LottoServices;
import lotto.view.ErrorView;
import lotto.view.InputViewer;
import lotto.view.OutputViewer;
import java.util.List;
import java.util.function.IntSupplier;
import java.util.function.IntConsumer;
import lotto.model.LottoGameState;

public class LottoController {
    private final LottoServices services;
    private final InputViewer inputViewer;
    private final OutputViewer outputViewer;
    private LottoGameState gameState;

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
        LottoStatistics statistics = createStatistics();
        List<Lotto> randomLotteries = createRandomLotteries(statistics);
        Lotto userLotto = createUserLotto();
        int bonusNumber = createBonusNumber();

        gameState = new LottoGameState(userLotto, randomLotteries, bonusNumber, statistics);
    }

    private LottoStatistics createStatistics() {
        int amount = readValidInput(inputViewer::readPurchaseAmount, LottoValidator::isValidAmount);
        int quantity = amount / 1000;
        return services.createLottoStatistics(amount, quantity);
    }

    private List<Lotto> createRandomLotteries(LottoStatistics statistics) {
        return services.createRandomLotteries(statistics);
    }

    private Lotto createUserLotto() {
        return services.createLotto(inputViewer.readUserLotto());
    }

    private int createBonusNumber() {
        return readValidInput(inputViewer::readBonusNumber, LottoValidator::isValidBonusNumber);
    }

    private void printInitState() {
        outputViewer.printLottoInitSummary(gameState.statistics().toDTO(), gameState.randomLotteries());
    }

    private void startLottoCheck() {
        services.checkLottoResults(gameState.statistics(), gameState.randomLotteries(), gameState.userLotto(), gameState.bonusNumber());
        services.checkLottoYield(gameState.statistics());
    }

    private void printLottoResult() {
        outputViewer.printLottoResult(gameState.statistics().toDTO());
    }

    private int readValidInput(IntSupplier inputMethod, IntConsumer validator) {
        while (true) {
            try {
                int value = inputMethod.getAsInt();
                validator.accept(value);
                return value;
            } catch(LottoException e) {
                ErrorView.displayError(e);
            } catch (NumberFormatException e) {
                ErrorView.displayError(new LottoNumberFormatException());
            }
        }
    }
}