package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.utils.LottoNumberGenerator;

public class LotteryMachine {
    public static final int LOTTO_PRICE = 1000;

    private final List<Lotto> lottos = new ArrayList<>();
    private final LottoNumberGenerator lottoNumberGenerator;

    public LotteryMachine(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public Lotto createLottoTicket(){
        return new Lotto(lottoNumberGenerator.generate());
    }

    public List<Lotto> createLottoByPayment(Money money){
        int amount = money.getLottoQuantity();
        for(int i =0; i<amount; i++){
            lottos.add(createLottoTicket());
        }
        return lottos;
    }
}
