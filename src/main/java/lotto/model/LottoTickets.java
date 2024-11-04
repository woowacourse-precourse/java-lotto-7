package lotto.model;

import lotto.generator.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private final List<Lotto> lottos;
    private final PurchaseAmount purchaseAmount;

    public LottoTickets(PurchaseAmount purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        this.lottos = generateLottos(purchaseAmount.getLottoCount());
    }

    private List<Lotto> generateLottos(int lottoCount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers = LottoNumberGenerator.generateLottoNumbers();
            lottoList.add(new Lotto(lottoNumbers));
        }
        return lottoList;
    }

    public int getLottoCount() {
        return purchaseAmount.getLottoCount();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getPurchaseAmount() {
        return purchaseAmount.getAmount();
    }
}
