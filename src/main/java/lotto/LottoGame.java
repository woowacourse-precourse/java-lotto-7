package lotto;

import lotto.exception.GameException;
import lotto.io.InputHandler;
import lotto.io.OutputHandler;
import lotto.model.*;
import lotto.provider.NumbersProvider;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        Lotto normalNumbersOfLotto = createWinningNumbers();
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

    private Lotto createWinningNumbers() {
        try {
            outputHandler.showWinningNumbersInstruction();
            String candidateWinningNumbers = inputHandler.getWinningNumbers().value();
            return convertLottoFrom(candidateWinningNumbers);
        } catch (GameException e) {
            System.out.println(e.getMessage());
            return createWinningNumbers();
        }
    }

    private Lotto convertLottoFrom(String candidateWinningNumbers) {
        List<Integer> winningNumbers = Arrays.stream(candidateWinningNumbers.split(","))
            .map(Integer::parseInt)
            .toList();
        return new Lotto(winningNumbers);
    }
    
}
