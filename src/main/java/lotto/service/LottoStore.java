package lotto.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumberGenerator;

public class LottoStore {

    private final int purchasePrice;
    private final List<Lotto> purchasedLotto = new LinkedList<>();
    private final int LOTTO_PRICE = 1000;

    public LottoStore(int purchaseAmount) {
        this.purchasePrice = purchaseAmount;
        this.purchasedLotto.addAll(purchaseLotto());
    }

    public List<Lotto> purchaseLotto() {
        int lottoCount = getNumberOfLotto();
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            purchasedLotto.add(new Lotto(LottoNumberGenerator.createRandomLotto()));
        }
        return lottoList;
    }

    public int getNumberOfLotto() {
        return purchasePrice / LOTTO_PRICE;
    }

    public List<Lotto> getPurchasedLotto() {
        return new ArrayList<>(purchasedLotto);
    }

}
