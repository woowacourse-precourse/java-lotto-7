package lotto.model.lotto;

import lotto.model.lotto.generator.LottoGenerator;
import lotto.model.lotto.generator.RandomLottoGenerator;

public class LottoTicket {
    private LottoGenerator lottoGenerator;

    public LottoTicket(LottoGenerator lottoGenerator) {
        this.lottoGenerator = new RandomLottoGenerator();
    }

    public void setLottoGenerator(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    private Lotto createLotto() {
        return new Lotto(lottoGenerator.generateLotto());
    }
}
