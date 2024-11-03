package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private final int count;
    private final NumbersGenerator numbersGenerator;

    public LottoMachine(int count, NumbersGenerator numbersGenerator) {
        this.count = count;
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
