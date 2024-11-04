package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class UserLottos {
    private final int purchaseAmount;
    private final int quantity;
    private final List<Lotto> lottos;

    public UserLottos(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
        this.quantity = calculateQuantity();
        this.lottos = createLottos();
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount == 0 || purchaseAmount % LottoInfo.PRICE.getInfo() != 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_THOUSAND_UNIT_ERROR.getMessage());
        }
    }

    private int calculateQuantity() {
        return this.purchaseAmount / LottoInfo.PRICE.getInfo();
    }

    private List<Lotto> createLottos() {
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < this.quantity; i++) {
            lottos.add(new Lotto(createRandomLottoNumbers()));
        }
        return lottos;
    }

    private List<Integer> createRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LottoInfo.FIRST_NUMBER.getInfo(), LottoInfo.LAST_NUMBER.getInfo(),
                LottoInfo.NUMBER_COUNT.getInfo());
    }

    public int getQuantity() {
        return this.quantity;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }
}
