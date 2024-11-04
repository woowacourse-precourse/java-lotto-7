package lotto.domain.machine;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.machine.generator.LottoGenerator;
import lotto.domain.machine.generator.NumberGenerator;

public class LottoMachine extends LottoGenerator {

    private final LottoMoney lottoMoney;

    public LottoMachine(NumberGenerator numberGenerator, LottoMoney lottoMoney) {
        super(numberGenerator);
        this.lottoMoney = lottoMoney;
    }

    public List<Lotto> issueLottos() {
        int drawCount = lottoMoney.getDrawCount();
        List<Lotto> lottos = new ArrayList<>(drawCount);

        for (int i = 0; i < drawCount; i++) {
            lottos.add(super.issueLotto());
        }

        return lottos;
    }

}
