package lotto.service;

import lotto.model.user.LotteryMachine;
import lotto.model.user.LottoResultDto;

public class LottoUserService {

    public LottoResultDto createLottoResult(final String insertedMoney) {
        return LottoResultDto.from(new LotteryMachine(insertedMoney));
    }
}
