package lotto.domain;

import static lotto.domain.LottoConstants.CAN_NOT_BUY_LOTTO;
import static lotto.domain.LottoConstants.CAN_NOT_BUY_LOTTO_AMOUNT;
import static lotto.domain.LottoConstants.GAME_PRICE;

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
        if (gameMoney % GAME_PRICE != 0) {
            throw new IllegalArgumentException(CAN_NOT_BUY_LOTTO_AMOUNT);
        }
    }

    public int cacluateGameCount() {
        return gameMoney / GAME_PRICE;
    }

    public int getgameMoney() {
        return gameMoney;
    }
}
