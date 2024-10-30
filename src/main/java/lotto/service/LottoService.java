package lotto.service;

import lotto.dto.CreateLottoInfo;
import lotto.dto.LottoRateInfo;
import lotto.model.UserLottoInfo;
import lotto.model.WinningLotto;

public class LottoService {

    public CreateLottoInfo getCreateLottoInfo(UserLottoInfo userLottoInfo) {
        return userLottoInfo.getUserLottos();
    }

    public LottoRateInfo getLottoRateInfo(WinningLotto winningLotto, UserLottoInfo userLottoInfo) {

        return null;
    }
}
