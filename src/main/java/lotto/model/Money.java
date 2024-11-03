package lotto.model;

import static lotto.model.constant.LottoRule.MAX_PURCHASE_COUNT;
import static lotto.model.constant.LottoRule.PRICE;

import java.util.List;
import lotto.dto.PurchaseMoneyRequestDTO;
import lotto.model.constant.LottoRank;

public class Money {
    private static final String INVALID_PURCHASE_AMOUNT_MESSAGE = "[ERROR] 구입금액은 1,000원 단위이어야 합니다.";
    private static final String INVALID_STANDARD_UNIT_MESSAGE = "[ERROR] 구입금액은 1,000 ~ 100,000까지 가능합니다.";

    private int money;

    public Money(PurchaseMoneyRequestDTO request) {
        validate(request.getMoney());
        this.money = request.getMoney();
    }

    public Money(List<LottoRank> ranks) {
        this.money = 0;
        for (LottoRank rank : ranks) {
            this.money += rank.getPrize();
        }
    }

    public int getMoney() {
        return money;
    }

    private void validate(int money) {
        validateRange(money);
        validateUnit(money);
    }

    private void validateRange(int money) {
        if (money < PRICE.getConstant() || money > PRICE.getConstant() * MAX_PURCHASE_COUNT.getConstant()) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT_MESSAGE);
        }
    }

    private void validateUnit(int money) {
        if (money % PRICE.getConstant() != 0) {
            throw new IllegalArgumentException(INVALID_STANDARD_UNIT_MESSAGE);
        }
    }

    public int exchangedForLottos() {
        int buyCount = money / PRICE.getConstant();
        this.money = 0;
        return buyCount;
    }
}
