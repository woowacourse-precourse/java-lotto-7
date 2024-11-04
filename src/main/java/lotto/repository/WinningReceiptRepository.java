package lotto.repository;

import java.util.HashMap;
import java.util.Map;
import lotto.domain.GameStatus;
import lotto.service.constant.prize.PrizeCondition;

public class WinningReceiptRepository {

    private static WinningReceiptRepository instance;
    private static Map<PrizeCondition, Long> prizeConditions;

    private WinningReceiptRepository() {
        prizeConditions = new HashMap<>();
    }

    public void add(PrizeCondition prizeCondition) {
        if (!prizeConditions.containsKey(prizeCondition)) {
            prizeConditions.put(prizeCondition, GameStatus.LOWEST_GAME_COUNT.get());
        }
        prizeConditions.replace(prizeCondition,
                prizeConditions.get(prizeCondition) + GameStatus.ADDED_GAME_COUNT.get());
    }

    public static WinningReceiptRepository getInstance() {
        if (instance == null) {
            instance = new WinningReceiptRepository();
        }
        return instance;
    }
}
