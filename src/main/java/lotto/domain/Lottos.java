package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    
    private List<Lotto> lottos = new ArrayList<>();
    private final NumbersGenerator numbersGenerator;

    public Lottos(int lottoCount, NumbersGenerator numbersGenerator) {
        this.numbersGenerator = numbersGenerator;
        this.lottos = generateLottos(lottoCount);
    }

    private List<Lotto> generateLottos(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = numbersGenerator.generate();
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
