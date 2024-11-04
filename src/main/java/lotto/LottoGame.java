package lotto;

import java.util.List;
import lotto.handler.InputHandler;
import lotto.handler.OutputHandler;

public class LottoGame {
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final LottoMachine lottoMachine;
    private final WinningStatics winningStatics = new WinningStatics();

    public LottoGame(InputHandler inputHandler, OutputHandler outputHandler, LottoMachine lottoMachine) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.lottoMachine = lottoMachine;
    }

    public void start() {
        Player player = createPlayer();
    }

    private Player createPlayer() {
        int purchaseAmount = inputHandler.readPurchaseAmountInput();
        List<Lotto> lottoes = lottoMachine.issueLottoes(purchaseAmount);
        outputHandler.printPurchaseResult(lottoes);
        return new Player(purchaseAmount, lottoes);
    }
}
