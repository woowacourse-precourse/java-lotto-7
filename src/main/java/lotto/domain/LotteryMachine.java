package lotto.domain;

import lotto.utils.LottoNumberGenerator;

public class LotteryMachine {
    private final LottoNumberGenerator lottoNumberGenerator;

    public LotteryMachine(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public Lotto createLottoTicket(){
        return new Lotto(lottoNumberGenerator.generate());
    }
}
