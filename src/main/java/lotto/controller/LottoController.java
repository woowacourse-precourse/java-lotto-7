package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoController {
    public void run() {
        int amount = InputView.requestPurchaseAmount();
        List<Lotto> purchasedLottos = generateLottos(amount / 1000);

        OutputView.printLottos(purchasedLottos);

        List<Integer> winningNumbers = InputView.requestWinningNumbers();
        int bonusNumber = InputView.requestBonusNumber();

        LottoResult result = calculateResults(purchasedLottos, winningNumbers, bonusNumber);
        OutputView.printResult(result, amount);
    }

    private List<Lotto> generateLottos(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> Lotto.generateRandomLotto())
                .collect(Collectors.toList());
    }

    private LottoResult calculateResults(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        LottoResult result = new LottoResult();
        for (Lotto lotto : lottos) {
            int matchCount = (int) lotto.getNumbers().stream()
                    .filter(winningNumbers::contains)
                    .count();
            boolean matchBonus = lotto.getNumbers().contains(bonusNumber);

            result.addResult(LottoRank.valueOf(matchCount, matchBonus));
        }
        return result;
    }
}