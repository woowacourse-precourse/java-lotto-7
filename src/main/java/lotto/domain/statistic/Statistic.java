package lotto.domain.statistic;

import java.util.List;
import lotto.domain.prize.WinningStatus;
import lotto.domain.user.User.UserLottoInfo;

public class Statistic {
    private int first = 0;
    private int second = 0;
    private int third = 0;
    private int fourth = 0;
    private int fifth = 0;

    public double getInterestRate(List<UserLottoInfo> userLottoInfos, long purchaseCost) {
        long sum = getPrizeSum(userLottoInfos);

        double yield = transformToPercentage(purchaseCost, sum);

        return roundToTwoDecimalPlaces(yield);
    }

    private static long getPrizeSum(List<UserLottoInfo> userLottoInfos) {
        return userLottoInfos.stream()
                .mapToLong(userLottoInfo -> userLottoInfo.getWinningStatus()
                        .getWinningMoney())
                .sum();
    }

    private static double transformToPercentage(long sum, long purchaseCost) {
        return sum / (double)purchaseCost * 100;
    }

    private static double roundToTwoDecimalPlaces(double yield) {
        return Math.round(yield * 10) / 10.0;
    }


    public void setWinningStatistics(List<UserLottoInfo> lottoInfos) {
        for (UserLottoInfo userlottoInfo : lottoInfos) {
            if (userlottoInfo.getWinningStatus() == WinningStatus.first) {
                first++;
            }
            if (userlottoInfo.getWinningStatus() == WinningStatus.second) {
                second++;
            }
            if (userlottoInfo.getWinningStatus() == WinningStatus.third) {
                third++;
            }
            if (userlottoInfo.getWinningStatus() == WinningStatus.fourth) {
                fourth++;
            }
            if (userlottoInfo.getWinningStatus() == WinningStatus.fifth) {
                fifth++;
            }
        }
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    public int getThird() {
        return third;
    }

    public int getFourth() {
        return fourth;
    }

    public int getFifth() {
        return fifth;
    }
}
