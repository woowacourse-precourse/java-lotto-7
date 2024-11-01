package lotto.model.lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.model.lotto.generator.LottoGenerator;
import lotto.model.lotto.generator.RandomLottoGenerator;

public class LottoTicket {
    private final List<Lotto> lottos = new ArrayList<>();
    private LottoGenerator lottoGenerator;

    public LottoTicket(int count) {
        this(new RandomLottoGenerator(), count);
    }

    public LottoTicket(LottoGenerator lottoGenerator, int count) {
        this.lottoGenerator = lottoGenerator;
        generateLottos(count);
    }

    private void generateLottos(int count) {
        for (int i = 0; i < count; i++) {
            lottos.add(generateLotto());
        }
    }

    private Lotto generateLotto() {
        return lottoGenerator.generateLotto();
    }
}
