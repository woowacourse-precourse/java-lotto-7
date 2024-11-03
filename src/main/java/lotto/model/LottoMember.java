package lotto.model;

import lotto.utils.constants.LottoPrize;

import java.util.ArrayList;
import java.util.List;

public class LottoMember {

    private final List<Lotto> purchasedLotto;
    List<Integer> purchasedLottoNumbers = new ArrayList<>();
    private List<LottoPrize> lottoResult;

    public LottoMember() {
        this.purchasedLotto = new ArrayList<>();
        this.lottoResult = new ArrayList<>();
    }

    public List<Lotto> getPurchasedLotto() {
        for (Lotto lotto : purchasedLotto) {
            purchasedLottoNumbers.addAll(lotto.getLottoNumbers());
        }
        return purchasedLotto;
    }

    public void setPurchasedLotto(Lotto lotto) {
        purchasedLotto.add(lotto);
    }

    public void setLottoResult(List<LottoPrize> resultPrize) {
        this.lottoResult = resultPrize;
    }

    public List<LottoPrize> getLottoResult() {
        return lottoResult;
    }
}
