package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.input.ConsoleInputHandler;
import lotto.input.InputHandler;
import lotto.output.ConsoleOutputHandler;
import lotto.output.OutputHandler;
import lotto.util.RetryUtil;

public class Application {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final LottoMachine lottoMachine;

    public Application() {
        this.inputHandler = new ConsoleInputHandler();
        this.outputHandler = new ConsoleOutputHandler();
        this.lottoMachine = new LottoMachine();
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.run();
    }

    public void run() {
        int amount = readPurchaseAmount(inputHandler);
        List<Lotto> lottos = lottoMachine.purchaseLottos(amount);
        outputHandler.printLottos(lottos);

        Lotto winningLotto = readWinningNumbers(inputHandler);
        int bonusNumber = readBonusNumber(inputHandler, winningLotto);

        LottoResult result = new LottoResult(lottos, winningLotto, bonusNumber);
        outputHandler.printResult(result);
    }

    private Integer readPurchaseAmount(InputHandler inputHandler) {
        return RetryUtil.retryOnError(inputHandler::readPurchaseAmount);
    }

    private Lotto readWinningNumbers(InputHandler inputHandler) {
        List<Integer> winningNumbers = RetryUtil.retryOnError(inputHandler::readWinningNumbers);
        return new Lotto(winningNumbers);
    }

    private Integer readBonusNumber(InputHandler inputHandler, Lotto winningLotto) {
        return RetryUtil.retryOnError(() -> inputHandler.readBonusNumber(winningLotto));
    }
}
