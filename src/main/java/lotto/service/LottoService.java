package lotto.service;

import lotto.dto.CreateLottoInfo;
import lotto.dto.WinningStatistics;
import lotto.model.UserLottoInfo;
import lotto.model.WinningLotto;

public class LottoService {

    public CreateLottoInfo getCreateLottoInfo(UserLottoInfo userLottoInfo) {
        return userLottoInfo.getUserLottos();
    }

    public WinningStatistics getLottoRateInfo(WinningLotto winningLotto, UserLottoInfo userLottoInfo) {
        return userLottoInfo.getWinningStatistics(winningLotto);
    }
}
