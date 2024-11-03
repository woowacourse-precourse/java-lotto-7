package lotto.user;

import java.util.List;
import lotto.Lotto;
import lotto.prize.WinningStatus;

public class User {
    private final Integer purchaseCost;
    private final List<UserLottoInfo> lottoInfos;

    public User(List<UserLottoInfo> lottoInfos, Integer purchaseCost) {
        this.lottoInfos = lottoInfos;
        this.purchaseCost = purchaseCost;
    }

    public List<UserLottoInfo> getLottoInfos() {
        return lottoInfos;
    }

    public Integer getPurchaseCost() {
        return purchaseCost;
    }

    public static class UserLottoInfo {
        private final Lotto lotto;
        private final WinningStatus winningStatus;

        public UserLottoInfo(Lotto lotto, WinningStatus winningStatus) {
            this.lotto = lotto;
            this.winningStatus = winningStatus;
        }

        public WinningStatus getWinningStatus() {
            return winningStatus;
        }
    }
}
