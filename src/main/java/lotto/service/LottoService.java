package lotto.service;

import lotto.dto.CreateLottoInfo;
import lotto.model.UserLottoInfo;

public class LottoService {

    public CreateLottoInfo getCreateLottoInfo(UserLottoInfo userLottoInfo) {
        return userLottoInfo.getUserLottos();
    }
}
