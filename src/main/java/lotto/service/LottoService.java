package lotto.service;

import lotto.dto.GeneratedUserLottoInfo;
import lotto.dto.WinningStatistics;
import lotto.model.UserLottoInfo;
import lotto.model.WinningLotto;

public class LottoService {

    public GeneratedUserLottoInfo getGeneratedLottoInfo(lotto.model.UserLottoInfo userLottoInfo) {
        return userLottoInfo.getUserLottos();
    }

    public WinningStatistics getWinningStatistics(WinningLotto winningLotto, UserLottoInfo userLottoInfo) {
        return userLottoInfo.getWinningStatistics(winningLotto);
    }
}
