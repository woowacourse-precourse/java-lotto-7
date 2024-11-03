package lotto.domain.statistic;

import java.util.List;
import lotto.domain.prize.WinningStatus;
import lotto.domain.user.User.UserLottoInfo;

public class Statistic {

    private int fifth = 0;
    private int fourth = 0;
    private int third = 0;
    private int second = 0;
    private int first = 0;

    public double getInterestRate(List<UserLottoInfo> userLottoInfos, Integer purchaseCost) {
        double sum = userLottoInfos.stream()
                .mapToInt(userLottoInfo -> userLottoInfo.getWinningStatus()
                        .getWinningMoney())
                .sum();

        return (sum / purchaseCost) * 100;
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
