package lotto;

import lotto.exception.GameException;
import lotto.io.InputHandler;
import lotto.io.OutputHandler;
import lotto.model.Lotto;
import lotto.model.LottoVendingMachine;
import lotto.provider.NumbersProvider;

import java.util.List;

public class LottoGame {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final NumbersProvider numbersProvider;

    public LottoGame(InputHandler inputHandler, OutputHandler outputHandler, NumbersProvider numbersProvider) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.numbersProvider = numbersProvider;
    }

    public void run() {
        List<Lotto> lottos = purchaseLotto();
        outputHandler.showLottos(lottos);
    }

    private List<Lotto> purchaseLotto() {
        try {
            outputHandler.showPurchaseAmountInstruction();
            int budget = inputHandler.inputPurchaseAmount();
            LottoVendingMachine vendingMachine = new LottoVendingMachine(budget);
            return vendingMachine.purchaseAll(numbersProvider);
        } catch (GameException e) {
            System.out.println(e.getMessage());
            return purchaseLotto();
        }
    }
}
