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
        WinningLotto winningLotto = createBonusNumber(normalNumbersOfLotto);
        WinningResult winningResult = calculateResult(lottos, winningLotto);
        showResult(winningResult);
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

    private WinningLotto createBonusNumber(Lotto lotto) {
        try {
            outputHandler.showBonusNumberInstruction();
            int bonusNumber = inputHandler.getBonusNumber();
            return new WinningLotto(lotto, new BonusNumber(bonusNumber));
        } catch (GameException e) {
            System.out.println(e.getMessage());
            return createBonusNumber(lotto);
        }
    }

    private WinningResult calculateResult(List<Lotto> lottos, WinningLotto winningLotto) {
        Map<Rank, Integer> resultMap = Arrays.stream(Rank.values())
            .collect(Collectors.toMap(rank -> rank, rank -> 0));

        lottos.stream()
            .map(winningLotto::calculateRank)
            .forEach(rank -> resultMap.put(rank, resultMap.get(rank) + 1));

        return new WinningResult(resultMap);
    }

    private void showResult(WinningResult result) {
        outputHandler.showWinningStatisticsComment();
        outputHandler.showWinningResult(result);
    }
    
}
