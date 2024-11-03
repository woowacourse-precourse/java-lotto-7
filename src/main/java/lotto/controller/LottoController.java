package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.Prize;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoController {

    public void run() {
        List<Lotto> lotto = initializeLottos();
        OutputView.printLottos(lotto);

        List<Integer> winningNumbers = InputView.winningNumber();
        int bonusNumber = InputView.bonusNumber();

        LottoResult result = calculateLottoResult(lotto, winningNumbers, bonusNumber);
        OutputView.printResults(result.getRankResults());
        OutputView.printProfitRate(result.getProfitRate());
    }

    private List<Lotto> initializeLottos() {
        List<Lotto> lotto = new ArrayList<>();
        int lottoCount = InputView.purchaseAmount();
        if (lottoCount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
        lottoCount /= 1000;
        OutputView.purchaseCount(lottoCount);
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lotto.add(new Lotto(lottoNumbers));
        }
        return lotto;
    }

    private LottoResult calculateLottoResult(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        Map<Integer, Integer> rankResults = new HashMap<>();
        for (Lotto lotto : lottos) {
            int matchCount = lotto.countMatchingNumbers(winningNumbers);
            boolean bonusMatch = lotto.contains(bonusNumber);

            Prize prize = Prize.valueOf(matchCount, bonusMatch);
            rankResults.put(prize.ordinal(), rankResults.getOrDefault(prize.ordinal(), 0) + 1);
        }

        double profitRate = calculateProfitRate(rankResults, InputView.getPurchaseAmount());
        return new LottoResult(rankResults, profitRate);
    }

    private double calculateProfitRate(Map<Integer, Integer> rankResults, int purchaseAmount) {
        int totalPrize = 0;
        for (Prize prize : Prize.values()) {
            totalPrize += rankResults.getOrDefault(prize.ordinal(), 0) * prize.getPrizeMoney();
        }

        if (purchaseAmount == 0) {
            return 0.0;
        }

        return ((double) totalPrize / purchaseAmount) * 100;
    }
}
