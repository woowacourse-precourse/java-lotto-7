package lotto.service.numbers;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;

public class NumberService {
    private final WinningLottoService winningLottoService;
    private final BonusNumberService bonusNumberService;

    public NumberService(WinningLottoService winningLottoService, BonusNumberService bonusNumberService) {
        this.winningLottoService = winningLottoService;
        this.bonusNumberService = bonusNumberService;
    }

    public Lotto winningLotto(String number) {
        return winningLottoService.generateWinningLotto(number);
    }
    public BonusNumber winningBonusNumber(String number, Lotto winningLotto) {
        return bonusNumberService.generateBonusNumber(number, winningLotto);
    }

}
