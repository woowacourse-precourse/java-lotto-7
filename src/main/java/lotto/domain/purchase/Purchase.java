package lotto.domain.purchase;

import java.util.List;
import lotto.common.LottoValidateUtil;
import lotto.domain.lotto.Lotto;

public class Purchase {
    private final int amount;
    private List<Lotto> lottos;

    public Purchase(int amount) {
        validate(amount);
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void setLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    private void validate(int amount) {
        LottoValidateUtil.validatePurchaseAmount(amount);
    }
}
