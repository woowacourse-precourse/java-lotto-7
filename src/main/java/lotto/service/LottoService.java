package lotto.service;

import lotto.dto.GeneratedUserLotto;
import lotto.dto.WinningStatistics;
import lotto.model.UserLottoInfo;
import lotto.model.WinningLotto;

public class LottoService {

    public GeneratedUserLotto getGeneratedLottoInfo(lotto.model.UserLottoInfo userLottoInfo) {
        return userLottoInfo.getUserLottos();
    }

    public WinningStatistics getWinningStatistics(WinningLotto winningLotto, UserLottoInfo userLottoInfo) {
        return userLottoInfo.getWinningStatistics(winningLotto);
    }
}
