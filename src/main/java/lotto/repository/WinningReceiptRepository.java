package lotto.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    public Long getCount(PrizeCondition prizeCondition) {
        if (prizeConditions.containsKey(prizeCondition)) {
            return prizeConditions.get(prizeCondition);
        }
        return GameStatus.LOWEST_GAME_COUNT.get();
    }

    public Boolean prizeConditionExist() {
        return !prizeConditions.isEmpty();
    }

    public Long orderPrizeMoneySum(PrizeCondition prizeCondition) {
        return prizeCondition.getPrizeMoney() * prizeConditions.get(prizeCondition);
    }

    public List<PrizeCondition> getPrizeConditions() {
        return new ArrayList<>(prizeConditions.keySet());
    }

    public static WinningReceiptRepository getInstance() {
        if (instance == null) {
            instance = new WinningReceiptRepository();
        }
        return instance;
    }
}
