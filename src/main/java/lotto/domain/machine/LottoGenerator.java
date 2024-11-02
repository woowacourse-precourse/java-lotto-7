package lotto.domain.machine;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.Lotto;

public class LottoGenerator {

    private final NumberGenerator numberGenerator;

    public LottoGenerator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<Lotto> issueLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(issueLotto());
        }
        return lottos;
    }

    public Lotto issueLotto() {
        return Lotto.from(numberGenerator.generate());
    }

}
