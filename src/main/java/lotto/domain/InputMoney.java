package lotto.domain;

import static lotto.utils.Constant.LOTTO_PRICE;
import static lotto.utils.Constant.MINIMUM_PRICE;

public record InputMoney(long amount) {
    public InputMoney {
        validateInputMoney(amount);
    }

    public long getBuyAmount() {
        if (this.amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로만 입력해야 합니다");
        }
        return amount / LOTTO_PRICE;
    }

    private void validateInputMoney(long userInputMoney) {
        if (userInputMoney < MINIMUM_PRICE) {
            throw new IllegalArgumentException("[ERROR] 0원 이상 결제해야 합니다.");
        }
    }
}
