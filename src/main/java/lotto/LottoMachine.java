package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private final List<Lotto> generatedLottos = new ArrayList<>();

    public List<Lotto> generateLottos(PurchaseAmount purchaseAmount) {
        int quantity = calculateTicketQuantity(purchaseAmount);

        for (int count = 0; count < quantity; count++) {
            generatedLottos.add(new Lotto(getRandomLottoNumbers()));
        }
        return generatedLottos;
    }

    private int calculateTicketQuantity(PurchaseAmount purchaseAmount) {
        return purchaseAmount.getAmount() / LottoRules.LOTTO_TICKET_PRICE;
    }

    private List<Integer> getRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LottoRules.MIN_NUMBER, LottoRules.MAX_NUMBER,
                LottoRules.NUMBERS_REQUIRED);
    }
}


