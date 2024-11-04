package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.model.dto.DrawResult;
import lotto.model.dto.DrawResults;

public class Lottos {

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public static Lottos randomFrom(int size) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            lottos.add(Lotto.randomCreate());
        }

        return new Lottos(lottos);
    }

    public boolean isSize(int size) {
        return this.lottos.size() == size;
    }

    public List<List<Integer>> getLottos() {
        List<List<Integer>> allLottos = new ArrayList<>();

        for (Lotto lotto : this.lottos) {
            allLottos.add(lotto.getNumbers());
        }

        return allLottos;
    }

    public DrawResults getDrawResult(Lotto winningLotto, int bonusNum) {
        List<DrawResult> results = new ArrayList<>();

        for (Lotto singleLotto : lottos) {
            results.add(generateResult(singleLotto, winningLotto, bonusNum));
        }

        return new DrawResults(results);
    }

    private DrawResult generateResult(Lotto singleLotto, Lotto winningLotto, int bonusNum) {
        int calculateResult = singleLotto.calculateDrawResult(winningLotto);
        boolean hasBonusNum = false;

        if (calculateResult == 5) {
            calculateResult += singleLotto.calculateBonusResult(bonusNum);
            hasBonusNum = true;
        }

        return new DrawResult(calculateResult, hasBonusNum);
    }

}
