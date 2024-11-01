package lotto.service;

import lotto.model.LotteryMachine;
import lotto.model.dto.LottoResultDto;

public class LottoUserService {

    public LottoResultDto createLottoResult(final String insertedMoney) {
        return LottoResultDto.from(new LotteryMachine(insertedMoney));
    }
}
