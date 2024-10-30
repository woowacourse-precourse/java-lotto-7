package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.dto.LottoWinResult;
import lotto.enums.LottoCalEnum;
import lotto.enums.LottoCriteria;

public class LottoCalculator {

    private static final Map<Integer, Integer> lottoCalMap = new HashMap<>();

    static {
        for(LottoCalEnum lottoCalEnum : LottoCalEnum.values()){
            lottoCalMap.put(lottoCalEnum.getWinCount(),lottoCalEnum.getWinMoney());
        }
    }

    public static int cal(int winCount, boolean isBonus){
        if(isBonusCase(winCount,isBonus)){
            winCount = 7;
        }
        return lottoCalMap.get(winCount);
    }

    private static boolean isBonusCase(int winCount, boolean isBonus){
        return winCount == LottoCriteria.BONUS_LOTTO_NUM.getCriteriaVal() && isBonus;
    }

    public static double getStatisticResult(List<LottoWinResult> lottoWinResultList, int buyMoney) {
        int winMoneySum = lottoWinResultList.stream()
                .mapToInt((winResult) -> winResult.winMoney())
                .sum();

        return winMoneySum / buyMoney;
    }
}
