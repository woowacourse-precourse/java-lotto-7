package lotto;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResultProcessor {
    List<Integer> winNumbers;
    List<List<Integer>> lottos;
    int bonusNum;

    int initMoney;

    Map<String, Integer> enumResult = new HashMap<>();

    public LottoResultProcessor(int initMoney, List<Integer> winNumbers, List<List<Integer>> lottos, int bonusNum) {
        this.winNumbers = winNumbers;
        this.lottos = lottos;
        this.bonusNum = bonusNum;
        this.initMoney = initMoney;
        initMap();
    }

    public void initMap() {
        for (EnumValue value : EnumValue.values()) {
            enumResult.put(value.name(), 0);
        }
    }
}
