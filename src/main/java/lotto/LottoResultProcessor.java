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

    private void countCorrect(List<Integer> lotto) {
        int correctNum = 0;
        boolean hasBonus = false;
        for (int number : lotto) {
            if (winNumbers.contains(number)) {
                correctNum++;
            }
            if (number == bonusNum) {
                hasBonus = true;
            }
        }
        classifyResult(correctNum, hasBonus);
    }

    public void classifyResult(Integer count, boolean hasBonus) {
        String correctName = EnumValue.winningResult(hasBonus, count);
        if (!correctName.equals("NO_CORRECT")) {
            int correctValue = enumResult.get(correctName);
            enumResult.put(correctName, correctValue + 1);
        }
    }

    public void getResult() {
        for (List<Integer> lotto : lottos) {
            countCorrect(lotto);
        }
    }

    public double calculateRatio(int totalMoney) {
        double ratio = (double) totalMoney / (double) initMoney * 100;
        double roundedNum = Math.round(ratio * 100) / 100.0; // 3.14

        return roundedNum;
    }

    public double getTotalProfit() {
        int totalMoney = 0;
        for (String name : enumResult.keySet()) {
            int winningMoney = EnumValue.valueOf(name).getMoney();
            int matchCount = enumResult.get(name);
            totalMoney += winningMoney * matchCount;
        }
        return calculateRatio(totalMoney);
    }
}
