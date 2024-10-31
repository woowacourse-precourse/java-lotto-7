package lotto.service.numbers;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.User;
import lotto.service.numbers.BonusNumberService;
import lotto.service.numbers.WinningLottoService;
import lotto.service.user.LottoGeneratorService;
import lotto.utils.PurchaseCalculator;

public class LottoService {
    private final WinningLottoService winningLottoService;
    private final BonusNumberService bonusNumberService;

    public LottoService(WinningLottoService winningLottoService, BonusNumberService bonusNumberService) {
        this.winningLottoService = winningLottoService;
        this.bonusNumberService = bonusNumberService;
    }

}
