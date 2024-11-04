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
        String input = InputView.getPrice();
        LottoValidator.validatePrice(input);
        int price = Integer.parseInt(input);
        int amount = price / 1000;

        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            lottos.add(LottoGenerator.generateLottoNumbers());
        }
        OutputView.printLottoNumbers(amount, lottos.stream()
                .map(Lotto::getNumbers)
                .toList());

        Lotto winningLotto = InputView.getWinningNumbers();
        int bonusNumber = InputView.getBonusNumber(winningLotto.getNumbers());

        LottoValidator.validateWinningNumbers(winningLotto.getNumbers());
        LottoValidator.validateBonusNumber(bonusNumber, winningLotto.getNumbers());

        Map<LottoRank, Integer> rankCounts = new HashMap<>();
        for (Lotto userLotto : lottos) {
            LottoRank rank = LottoComparison.compareLottoNumbers(winningLotto.getNumbers(), bonusNumber, userLotto.getNumbers());
            rankCounts.put(rank, rankCounts.getOrDefault(rank, 0) + 1);
        }
        double profitRate = LottoComparison.calculateProfitRate(rankCounts, price);
        OutputView.printWinningStatistics(rankCounts, profitRate);
    }
}
