package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.view.InputView.purchaseAmount;

public class LottoController {

    public void run() {
        List<Lotto> lottos = initializeLottos();
        OutputView.printLottos(lottos);
        List<Integer> winningNumbers = InputView.winningNumber();
        int bonusNumber = InputView.bonusNumber();
        Map<Integer, Integer> rankResults = calculateResults(lottos, winningNumbers, bonusNumber);
        OutputView.printResults(rankResults);

        double profitRate = calculateProfitRate(rankResults);
        OutputView.printProfitRate(profitRate);
    }

    private List<Lotto> initializeLottos() {
        List<Lotto> lottos = new ArrayList<>();
        int lottoCount = InputView.purchaseAmount();
        if (lottoCount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
        lottoCount /= 1000;
        OutputView.purchaseCount(lottoCount);
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(lottoNumbers));
        }
        return lottos;
    }

    private Map<Integer, Integer> calculateResults(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        Map<Integer, Integer> rankResults = new HashMap<>();

        for (Lotto lotto : lottos) {
            int matchCount = lotto.countMatchingNumbers(winningNumbers);
            boolean bonusMatch = lotto.contains(bonusNumber);

            int rank = determineRank(matchCount, bonusMatch);
            rankResults.put(rank, rankResults.getOrDefault(rank, 0) + 1);
        }
        return rankResults;
    }

    private int determineRank(int matchCount, boolean bonusMatch) {
        if (matchCount == 6) return 1;
        if (matchCount == 5 && bonusMatch) return 2;
        if (matchCount == 5) return 3;
        if (matchCount == 4) return 4;
        if (matchCount == 3) return 5;
        return -1;
    }

    private double calculateProfitRate(Map<Integer, Integer> rankResults) {
        int[] prizeMoney = {2_000_000_000, 30_000_000, 1_500_000, 50_000, 5_000};
        int totalPrize = 0;

        for (int i = 1; i <= 5; i++) {
            totalPrize += rankResults.getOrDefault(i, 0) * prizeMoney[i - 1];
        }

        return purchaseAmount > 0 ? ((double) totalPrize / purchaseAmount) * 100 : 0;
    }
}
