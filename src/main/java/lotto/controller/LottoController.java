package lotto.controller;

import lotto.model.Lotto;
import lotto.model.WinningRank;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoController {

    public void run() {
        int purchaseAmount = InputView.inputPurchaseAmount();
        List<Lotto> purchasedLottos = purchaseLottos(purchaseAmount / 1000);
        OutputView.printLottoNumbers(getLottoNubmers(purchasedLottos));

        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber(winningNumbers);

        List<WinningRank> results = calculateStatistics(purchasedLottos, winningNumbers, bonusNumber);
        OutputView.printStatistics(results);

        double profitRate = calculateProfitRate(results, purchaseAmount);
        OutputView.printProfitRate(profitRate);
    }

    private List<Lotto> purchaseLottos(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> Lotto.generateRandomLotto())
                .collect(Collectors.toList());
    }

    private List<List<Integer>> getLottoNubmers(List<Lotto> lottos) {
        return lottos.stream()
                .map(Lotto::getNumbers)
                .collect(Collectors.toList());
    }

    private List<WinningRank> calculateStatistics(List<Lotto> purchasedLottos, List<Integer> winningNumbers, int bonusNumber) {
        return purchasedLottos.stream()
                .map(lotto -> {
                    int matchCount = lotto.countMatches(winningNumbers);
                    boolean matchBonus = lotto.contains(bonusNumber);
                    return WinningRank.valueOf(matchCount, matchBonus);
                })
                .collect(Collectors.toList());
    }

    private double calculateProfitRate(List<WinningRank> results, int purchaseAmount) {
        int totalPrize = results.stream()
                .mapToInt(WinningRank::getPrize)
                .sum();

        return ((double) totalPrize / purchaseAmount * 100);
    }
}
