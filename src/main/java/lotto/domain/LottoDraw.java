package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoDraw {

    private final int count;
    private final NumbersGenerator numbersGenerator;

    public LottoDraw(PurchaseAmount purchaseAmount, NumbersGenerator numbersGenerator) {
        this.count = purchaseAmount.calculateLottoCount();
        this.numbersGenerator = numbersGenerator;
    }

    public List<Lotto> generateLottos() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = numbersGenerator.generate();
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }
}
