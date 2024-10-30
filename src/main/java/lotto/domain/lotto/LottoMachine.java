package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private final NumberGenerator numberGenerator;

    public LottoMachine(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<Lotto> issueLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(issueLotto());
        }
        return lottos;
    }

    private Lotto issueLotto() {
        return Lotto.from(numberGenerator.generate());
    }

}
