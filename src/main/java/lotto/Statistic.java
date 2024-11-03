package lotto;

import java.util.List;
import lotto.user.User.UserLottoInfo;

public class Statistic {

    public double getInterestRate(List<UserLottoInfo> userLottoInfos, Integer purchaseCost) {
        int sum = userLottoInfos.stream()
                .mapToInt(userLottoInfo -> userLottoInfo.getWinningStatus()
                        .getWinningMoney())
                .sum();

        return sum / purchaseCost;
    }
}
