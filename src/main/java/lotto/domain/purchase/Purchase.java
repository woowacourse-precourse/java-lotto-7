package lotto.domain.purchase;

import java.util.List;
import lotto.common.LottoValidateUtil;
import lotto.domain.lotto.Lotto;

public class Purchase {
    private final int amount;
    private List<Lotto> lottos;

    public Purchase(String amount) {
        this.amount = convertStringToInt(amount);
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

    private int convertStringToInt(String amount) {
        int parsedAmount;

        if (amount == null || amount.isBlank()) {
            amount = "";
        }
        String cleanAmount = amount.replace(" ", "");

        try {
            parsedAmount = Integer.parseInt(cleanAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 정수 형태의 금액을 입력해주세요.");
        }
        LottoValidateUtil.validatePurchaseAmount(parsedAmount);

        return parsedAmount;
    }
}
