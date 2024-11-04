package lotto.model;

import java.util.ArrayList;
import java.util.List;

import lotto.model.numbergenerator.NumberGenerator;

public class Lottos {

    private List<Lotto> lottos = new ArrayList<>();
    private NumberGenerator numberGenerator;
    private final Trial trial;

    public Lottos(NumberGenerator numberGenerator, Trial trial) {
        this.numberGenerator = numberGenerator;
        this.trial = trial;
        makeLottos();
    }

    public void makeLottos() {
        for (int i = 0; i < trial.getTrial(); i++) {
            lottos.add(new Lotto(numberGenerator.generateNumber()));
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public List<List<Integer>> getLottoNums() {
        List<List<Integer>> lottoNums = new ArrayList<>();
        for (Lotto lotto : lottos) {
            lottoNums.add(lotto.getNumbers());
        }
        return lottoNums;
    }
}
