package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoPurchaser {

    private final List<Lotto> purchasedLottos;
    private final NumberGenerator numberGenerator;

    public LottoPurchaser(NumberGenerator numberGenerator) {
        purchasedLottos = new ArrayList<>();
        this.numberGenerator = numberGenerator;
    }

    public void purchaseLotto() {
        List<Integer> lottoNumber = numberGenerator.generateNumber();
        purchasedLottos.add(new Lotto(lottoNumber));
    }

    public List<Lotto> getPurchasedLottos() {
        return purchasedLottos;
    }
}
