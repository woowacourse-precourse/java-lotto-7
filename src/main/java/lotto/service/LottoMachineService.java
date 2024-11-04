package lotto.service;

import lotto.model.LottoBundle;
import lotto.model.LottoMachine;
import lotto.model.WinningNumbers;

public class LottoMachineService {

    public LottoMachine generateLottoMachine(LottoBundle lottoBundle, WinningNumbers winningNumbers) {
        return new LottoMachine(winningNumbers, lottoBundle);
    }
}
