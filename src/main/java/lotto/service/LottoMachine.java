package lotto.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.enums.ErrorMessage;
import lotto.model.Lotto;
import lotto.utils.Utils;

public class LottoMachine {
    private List<Lotto> tickets = new ArrayList<>();
    private int purchaseAmount;

    public List<Lotto> createLottoTicket(BigDecimal purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount.intValue();
        int count = calculatorLottoCount(purchaseAmount.intValue());

        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto(createRandomLottoNum());
            tickets.add(lotto);
        }
        return tickets;
    }

    private void validatePurchaseAmount(BigDecimal purchaseAmount) {
        if (!Utils.isInRange(new BigDecimal("1000"), new BigDecimal("100000"), purchaseAmount)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE.getMessage());
        }
        if (!Utils.isDivisibleByThousand(purchaseAmount.intValue())) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DIVISIBLE_BY_THOUSAND.getMessage());
        }
    }

    private List<Integer> createRandomLottoNum() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private int calculatorLottoCount(int count) {
        return count / 1000;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}