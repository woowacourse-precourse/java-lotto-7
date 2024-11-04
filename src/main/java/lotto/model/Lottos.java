package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public static Lottos randomFrom(int size) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            lottos.add(Lotto.randomCreate());
        }

        return new Lottos(lottos);
    }

    public List<List<Integer>> getLottos() {
        List<List<Integer>> allLottos = new ArrayList<>();

        for (Lotto lotto : this.lottos) {
            Collections.sort(new ArrayList<>(lotto.getNumbers()));
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

        if (calculateResult == 5 && singleLotto.hasBonusNum(bonusNum)) {
            calculateResult++;
            hasBonusNum = true;
        }

        return new DrawResult(calculateResult, hasBonusNum);
    }

}
