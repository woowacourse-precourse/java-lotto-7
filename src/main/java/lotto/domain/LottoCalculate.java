package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.global.LottoScore;

public class LottoCalculate {

    private List<LottoScore> lottoScores = new ArrayList<>();

    public void calculateLottoNumbers(List<Integer> winningLottoNumber, List<Lotto> randomLotto, int bonusNumber) {
        for (Lotto lotto : randomLotto) {
            int correctCounts = calculateLotto6Numbers(winningLottoNumber, lotto.getNumbers());
            boolean correctBonus = calculateBonusNumber(bonusNumber, lotto.getNumbers());
            LottoScore lottoScore = LottoScore.of(correctCounts, correctBonus);
            lottoScores.add(lottoScore);
        }
    }

    public List<LottoScore> getLottoScores() {
        return lottoScores;
    }

    private int calculateLotto6Numbers(List<Integer> winningLottoNumber, List<Integer> randomLottoNumber) {
        List<Integer> intersection = new ArrayList<>(winningLottoNumber);
        intersection.retainAll(randomLottoNumber);
        return intersection.size();
    }

    private boolean calculateBonusNumber(int bonusNumber, List<Integer> randomLottoNumber) {
        return randomLottoNumber.contains(bonusNumber);
    }
}