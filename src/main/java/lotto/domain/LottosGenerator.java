package lotto.domain;

import static lotto.util.Constants.LOTTO_PRICE;

import java.util.ArrayList;
import java.util.List;

public class LottosGenerator {
    private final NumbersGenerator numberGenerator;

    public LottosGenerator(NumbersGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<Lotto> generate(int purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchaseAmount / LOTTO_PRICE; i++) {
            lottos.add(new Lotto(numberGenerator.generate()));
        }
        return lottos;
    }
}
