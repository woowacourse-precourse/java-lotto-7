package lotto;

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
        validatePositiveNumber(purchaseAmount);
        validateThousandUnitAmount(purchaseAmount);
    }

    private void validatePositiveNumber(int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException(ErrorMessage.POSITIVE_AMOUNT_ERROR.getMessage());
        }
    }

    private void validateThousandUnitAmount(int purchaseAmount) {
        if (purchaseAmount % LottoInfo.PRICE.getInfo() != 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_THOUSAND_UNIT_ERROR.getMessage());
        }
    }

    private int calculateQuantity() {
        return this.purchaseAmount / LottoInfo.PRICE.getInfo();
    }

    private List<Lotto> createLottos() {
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < this.quantity; i++) {
            lottos.add(new Lotto(LottoNumbersCreator.createRandomLottoNumbers()));
        }
        return lottos;
    }

    public String getUserLottoNumbers() {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : this.lottos) {
            sb.append(lotto.getNumbers().toString()).append("\n");
        }
        return sb.toString().trim();
    }

    public int getPurchaseAmount() {
        return this.purchaseAmount;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }
}
