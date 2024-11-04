package lotto.domain.user;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.prize.WinningStatus;

public class User {
    private final long purchaseCost;
    private final List<UserLottoInfo> lottoInfos;

    public User(List<UserLottoInfo> lottoInfos, long purchaseCost) {
        this.lottoInfos = lottoInfos;
        this.purchaseCost = purchaseCost;
    }

    public List<UserLottoInfo> getLottoInfos() {
        return lottoInfos;
    }

    public long getPurchaseCost() {
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
