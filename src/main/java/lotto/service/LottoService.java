package lotto.service;

import lotto.dto.GeneratedLottoInfo;
import lotto.dto.WinningStatistics;
import lotto.model.WinningLotto;

public class LottoService {

    public GeneratedLottoInfo getGeneratedLottoInfo(lotto.model.UserLottoInfo userLottoInfo) {
        return userLottoInfo.getUserLottos();
    }

    public WinningStatistics getWinningStatistics(WinningLotto winningLotto, lotto.model.UserLottoInfo userLottoInfo) {
        return userLottoInfo.getWinningStatistics(winningLotto);
    }
}
