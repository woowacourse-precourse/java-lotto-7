package lotto;

import lotto.exception.GameException;
import lotto.io.LottoIOHandler;
import lotto.model.*;
import lotto.provider.NumbersProvider;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoGame {

    private final LottoIOHandler ioHandler = new LottoIOHandler();
    private final NumbersProvider numbersProvider;

    public LottoGame(NumbersProvider numbersProvider) {
        this.numbersProvider = numbersProvider;
    }

    public void run() {
        List<Lotto> lottos = purchaseLotto();
        ioHandler.showPurchasedLottos(lottos);
        Lotto normalNumbersOfLotto = createWinningNumbers();
        WinningLotto winningLotto = createBonusNumber(normalNumbersOfLotto);
        WinningResult winningResult = calculateResult(lottos, winningLotto);
        showResult(winningResult);
    }

    private List<Lotto> purchaseLotto() {
        try {
            int budget = ioHandler.askPurchaseAmount();
            LottoVendingMachine vendingMachine = new LottoVendingMachine(budget);
            return vendingMachine.purchaseAll(numbersProvider);
        } catch (GameException e) {
            System.out.println(e.getMessage());
            return purchaseLotto();
        }
    }

    private Lotto createWinningNumbers() {
        try {
            String candidateWinningNumbers = ioHandler.askWinningNumbers();
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
            int bonusNumber = ioHandler.askBonusNumber();
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
        ioHandler.showWinningStatistics(result);
    }

}
