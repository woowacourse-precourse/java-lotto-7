package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private NumberGenerator numberGenerator;

    public LottoMachine(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public Lottos buyLottos(int quantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            Lotto lotto = new Lotto(numberGenerator.generate());
            lottos.add(lotto);
        }
        return new Lottos(lottos);
    }
}
