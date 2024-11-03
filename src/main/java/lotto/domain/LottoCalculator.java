package lotto.domain;

import java.util.ArrayList;
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
        if(!isWinLottoMoney(winCount)){
            return 0;
        }
        if(isBonusCase(winCount,isBonus)){
            winCount = LottoCriteria.BONUS_CASE_SPECIAL_LOTTO_NUM.getCriteriaVal();
        }
        return lottoCalMap.get(winCount);
    }

    private static boolean isWinLottoMoney(int winCount){
        return winCount >= LottoCriteria.MIN_WIN_COUNT.getCriteriaVal();
    }

    private static boolean isBonusCase(int winCount, boolean isBonus){
        return winCount == LottoCriteria.BONUS_LOTTO_NUM.getCriteriaVal() && isBonus;
    }

    public static double caluateWinMoneyRate(List<LottoWinResult> lottoWinResultList, int buyMoney) {
        int winMoneySum = lottoWinResultList.stream()
                .mapToInt((winResult) -> winResult.winMoney())
                .sum();
        double rate = ((double) winMoneySum / buyMoney) * 100;
        return Math.round(rate * 100) / 100.0;
    }

    public static Map<Integer,List<LottoWinResult>> getWinLottoResultMap(List<LottoWinResult> lottoWinResultList) {
        Map<Integer,List<LottoWinResult>> lottoWinCountResultMap = new HashMap<>();

        for(LottoWinResult lottoWinResult : lottoWinResultList){
            List<LottoWinResult> winResultList = lottoWinCountResultMap.getOrDefault(lottoWinResult.winCount(),new ArrayList<>());
            winResultList.add(lottoWinResult);
            lottoWinCountResultMap.put(lottoWinResult.winCount(),winResultList);
        }
        return lottoWinCountResultMap;
    }
}
