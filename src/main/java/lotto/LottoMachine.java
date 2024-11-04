package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private final List<lotto.Lotto> generatedLottos = new ArrayList<>();

    public List<lotto.Lotto> generateLotto(PurchaseAmount purchaseAmount) {
        int quantity = calculateLottoQuantity(purchaseAmount);

        for (int count = 0; count < quantity; count++) {
            generatedLottos.add(new lotto.Lotto(getRandomLottoNumbers()));
        }
        return generatedLottos;
    }

    public int calculateLottoQuantity(PurchaseAmount purchaseAmount) {
        return purchaseAmount.getAmount() / lotto.LottoRules.LOTTO_TICKET_PRICE;
    }

    private List<Integer> getRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LottoRules.MIN_NUMBER, LottoRules.MAX_NUMBER,
                LottoRules.NUMBERS_REQUIRED);
    }
}


