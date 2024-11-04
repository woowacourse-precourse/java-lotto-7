package lotto.service;

import lotto.model.Lotto;

import java.util.*;

public class LottoService {
    private final List<Integer> winningNumbers;
    private final int winningBonusNumber;
    private final LottoStatistics lottoStatistics;
    private final LottoProfitCalculator lottoProfitCalculator;

    public LottoService(List<Integer> winningNumbers, int winningBonusNumber) {
        this.winningNumbers = winningNumbers;
        this.winningBonusNumber = winningBonusNumber;
        this.lottoStatistics = new LottoStatistics(winningNumbers, winningBonusNumber);
        this.lottoProfitCalculator = new LottoProfitCalculator();
    }

    public static Lotto createLotto() {
        return LottoCreator.createLotto();
    }

    public LinkedHashMap<String, Integer> calculateUserLottoStatistics(List<Lotto> userLottos) {
        return lottoStatistics.calculateUserLottoStatistics(userLottos);
    }

    public double calculateRateOfReturn(LinkedHashMap<String, Integer> userLottoStatistics, int purchaseAmount) {
        return lottoProfitCalculator.calculateRateOfReturn(userLottoStatistics, purchaseAmount);
    }

}
