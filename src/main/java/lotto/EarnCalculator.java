package lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class EarnCalculator {
    public static Integer getEarn(List<LottoWinner> wonDataList) {
        Integer earnSum = 0;
        for (LottoWinner wonData : wonDataList) {
            earnSum += wonData.getWinAmount() * wonData.getWinPrize();
        }
        return earnSum;
    }

    public static Double getEarnRate(Integer moneyAmount, List<LottoWinner> wonDataList) {
        Integer earnSum = getEarn(wonDataList);
        BigDecimal bd = new BigDecimal(earnSum / moneyAmount);
        return bd.setScale(2, RoundingMode.HALF_UP).doubleValue();

    }
}
