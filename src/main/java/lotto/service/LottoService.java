package lotto.service;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Score;

public class LottoService {
    private final LottoGenerator lottoGenerator;
    private final LottoResultChecker lottoResultChecker;

    private static final int LOTTO_PRICE = 1000;

    public LottoService(LottoGenerator lottoGenerator, LottoResultChecker lottoResultChecker) {
        this.lottoGenerator = lottoGenerator;
        this.lottoResultChecker = lottoResultChecker;
    }

    public List<Lotto> purchaseLottos(int purchaseAmount) {
        int lottoCount = purchaseAmount / LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();
        while (lottoCount-- > 0) {
            Lotto lotto = lottoGenerator.generateByRandom();
            lottos.add(lotto);
        }
        return lottos;
    }

    public Lotto generateWinningLotto(List<Integer> winningNums) {
        return lottoGenerator.generateByNums(winningNums);
    }

    public List<Score> calculateScores(List<Lotto> lottos, Lotto winningLotto, int bonusNum) {
        List<Score> scores = new ArrayList<>();
        for (Lotto lotto : lottos) {
            Score score = lottoResultChecker.calculateScore(lotto, winningLotto, bonusNum);
            scores.add(score);
        }
        return scores;
    }

    public Map<Score, Integer> calculateScoreCount(List<Score> scores) {
        Map<Score, Integer> scoreCount = new EnumMap<>(Score.class);
        for (Score score : scores) {
            scoreCount.put(score, scoreCount.getOrDefault(score, 0) + 1);
        }
        return scoreCount;
    }

    public int calculateTotalPrizeMoney(List<Score> finalScore) {
        int totalPrizeMoney = finalScore.stream().map(Score::getPrizeMoney).reduce(0, Integer::sum);
        return totalPrizeMoney;
    }

    public double calculateRateOfReturn(int totalPrizeMoney, int money) {
        double rate = (double) totalPrizeMoney / money * 100;
        return rate;
    }
}
