package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.utility.LottoComparison;
import lotto.utility.LottoGenerator;
import lotto.validator.LottoValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoController {
    public void run() {
        int price = getPurchasePrice();
        List<Lotto> lottos = generateLottos(price);
        OutputView.printLottoNumbers(lottos.size(), lottos.stream().map(Lotto::getNumbers).toList());

        Lotto winningLotto = InputView.getWinningNumbers();
        int bonusNumber = InputView.getBonusNumber(winningLotto.getNumbers());

        validateWinningInput(winningLotto, bonusNumber);

        Map<LottoRank, Integer> rankCounts = countRanks(lottos, winningLotto.getNumbers(), bonusNumber);
        double profitRate = LottoComparison.calculateProfitRate(rankCounts, price);
        OutputView.printWinningStatistics(rankCounts, profitRate);
    }

    private int getPurchasePrice() {
        String input = InputView.getPrice();
        LottoValidator.validatePrice(input);
        return Integer.parseInt(input);
    }

    private List<Lotto> generateLottos(int price) {
        int amount = price / 1000;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            lottos.add(LottoGenerator.generateLottoNumbers());
        }
        return lottos;
    }

    private void validateWinningInput(Lotto winningLotto, int bonusNumber) {
        LottoValidator.validateWinningNumbers(winningLotto.getNumbers());
        LottoValidator.validateBonusNumber(bonusNumber, winningLotto.getNumbers());
    }

    private Map<LottoRank, Integer> countRanks(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        Map<LottoRank, Integer> rankCounts = new HashMap<>();
        for (Lotto userLotto : lottos) {
            LottoRank rank = LottoComparison.compareLottoNumbers(winningNumbers, bonusNumber, userLotto.getNumbers());
            rankCounts.put(rank, rankCounts.getOrDefault(rank, 0) + 1);
        }
        return rankCounts;
    }
}
