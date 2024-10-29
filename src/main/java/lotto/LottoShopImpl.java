package lotto;

import static lotto.LottoConstants.LOTTO_PRICE;

import java.util.ArrayList;
import java.util.List;

public class LottoShopImpl implements LottoShop {
    private final LottoMachine lottoMachine;

    public LottoShopImpl(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    @Override
    public List<Lotto> publish(int purchaseAmount) {
        int purchaseQuantity = purchaseAmount / LOTTO_PRICE;
        return generateLottoByGenerator(purchaseQuantity);
    }

    private List<Lotto> generateLottoByGenerator(int purchaseQuantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchaseQuantity; i++) {
            lottos.add(lottoMachine.generateLotto());
        }
        return lottos;
    }

}
