package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoMember {

    private final List<Lotto> purchasedLotto;
    List<Integer> purchasedLottoNumbers = new ArrayList<>();

    public LottoMember() {
        this.purchasedLotto = new ArrayList<>();
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

    public void setLottoResult() {
    }

}
