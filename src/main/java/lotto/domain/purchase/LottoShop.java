package lotto.domain.purchase;

import lotto.domain.play.LottoGenerator;
import lotto.domain.ticket.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {
    private static final int PRICE = 1000;
    private final LottoGenerator lottoGenerator;

    public LottoShop(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public List<Lotto> purchaseLottoWith(LottoMoney lottoMoney) {
        int availableCount = lottoMoney.getValue() / PRICE;
        List<Lotto> lottos = new ArrayList<>(availableCount);
        for(int i = 0; i < availableCount; i++) {
            lottos.add(lottoGenerator.generate());
        }
        return lottos;
    }
}
