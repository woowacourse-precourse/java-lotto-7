package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoGrade;
import lotto.domain.Lottos;
import lotto.domain.TargetLotto;

import java.util.Map;

public class ProfitCalculator {

    private final Lottos lottos;
    private final TargetLotto targetLotto;

    public ProfitCalculator(Lottos lottos, TargetLotto targetLotto) {
        this.lottos = lottos;
        this.targetLotto = targetLotto;
    }

    public double calculateProfit() {
        Map<LottoGrade, Integer> lottoGradeCountMap = lottos.convertGrades(targetLotto);

        double sum = lottoGradeCountMap.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();

        int size = lottoGradeCountMap.size();

        return sum / size;
    }
}
