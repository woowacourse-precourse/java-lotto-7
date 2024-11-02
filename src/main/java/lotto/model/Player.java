package lotto.model;

import java.util.List;
import java.util.ArrayList;

public class Player {
    private final int purchaseAmount;
    private final List<Lotto> lottos;

    public Player(int perchaseAmount) {
        this.purchaseAmount = perchaseAmount;
        this.lottos = new ArrayList<>();
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    public List<String> getLottoNumbers() {
        List<String> LottoNumbers = new ArrayList<>();
        for (Lotto lotto : lottos) {
            LottoNumbers.add(lotto.toFormattedString());
        }
        return LottoNumbers;
    }
}
