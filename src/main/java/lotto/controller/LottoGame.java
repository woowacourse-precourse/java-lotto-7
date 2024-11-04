package lotto.controller;

import static lotto.constants.LottoConstants.LOTTO_NUMBER_COUNT;
import static lotto.constants.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.constants.LottoConstants.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lotto.service.LottoGenerationService;
import lotto.service.LottoResultService;
import lotto.service.LottoStatisticsService;
import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGame {
    private final LottoGenerationService generationService;
    private final LottoResultService resultService;
    private final LottoStatisticsService statisticsService;

    public LottoGame() {
        this.generationService = new LottoGenerationService();
        this.resultService = new LottoResultService();
        this.statisticsService = new LottoStatisticsService();
    }

    public void start() {
        int purchaseAmount = InputView.inputPurchaseAmount();
        List<Lotto> lottos = generationService.generateLottos(purchaseAmount);
        ResultView.printLottos(lottos);

        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber();

        Map<Rank, Integer> results = resultService.calculateResults(lottos, winningNumbers, bonusNumber);
        int totalPrize = statisticsService.calculateTotalPrize(results);
        double profitRate = statisticsService.calculateProfitRate(totalPrize, purchaseAmount);

        ResultView.printResults(results, profitRate);
    }

    public static List<Lotto> generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER,
                    LOTTO_NUMBER_COUNT);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        return lottos;
    }

    public static Map<Rank, Integer> calculateResults(List<Lotto> lottos, List<Integer> winningNumbers,
            int bonusNumber) {
        Map<Rank, Integer> resultMap = new HashMap<>();
        for (Lotto lotto : lottos) {
            int matchCount = getMatchCount(lotto.getNumbers(), winningNumbers);
            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);
            Rank rank = Rank.valueOf(matchCount, bonusMatch);
            resultMap.put(rank, resultMap.getOrDefault(rank, 0) + 1);
        }
        return resultMap;
    }

    public static int getMatchCount(List<Integer> numbers, List<Integer> winningNumbers) {
        int count = 0;
        for (int number : numbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }
}
