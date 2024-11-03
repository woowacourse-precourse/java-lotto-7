package lotto.domain;

import static lotto.domain.LottoConstants.CAN_NOT_BUY_LOTTO;

public class LottoPrice {
    private final int gameMoney;

    public LottoPrice(int gameMoney) {
        validateGameMoney(gameMoney);
        this.gameMoney = gameMoney;
    }

    private void validateGameMoney(int gameMoney) {
        if (gameMoney <= 0) {
            throw new IllegalArgumentException(CAN_NOT_BUY_LOTTO);
        }
    }
}
