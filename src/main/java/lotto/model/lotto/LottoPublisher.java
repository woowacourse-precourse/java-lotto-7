package lotto.model.lotto;

import lotto.model.number_generator.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoPublisher {

    private final NumberGenerator numberGenerator;

    public LottoPublisher(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<Lotto> publishLotto(long lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = createLottoNumbers();
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        return lottos;
    }

    private List<Integer> createLottoNumbers() {
        return numberGenerator.generate();
    }
}
