package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.util.RandomNumber;

public class Lottos {

    private List<Lotto> lottos;
    private int number;

    public Lottos(int number) {
        List<Lotto> generatedLotto = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            generatedLotto.add(new Lotto(RandomNumber.createRandomNumbers()));
        }
        this.lottos = generatedLotto;
    }
}
