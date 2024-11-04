package lotto.controller;

import java.util.EnumMap;
import lotto.domain.Lotto;
import lotto.domain.WinAmount;
import lotto.service.LottoService;
import lotto.view.Output;

public class LottoController {

    public void run() {
        LottoService lottoService = new LottoService();

        int count = lottoService.buyLotto();
        Lotto[] myLotto = generateMyLotto(lottoService, count);

        Lotto winNumbers = lottoService.setWinNumber();
        int bonusNumber = lottoService.setBonusNumber(winNumbers);

        EnumMap<WinAmount, Integer> WinLottoAmountHistory = lottoService.compare_My_Win(myLotto, winNumbers.getNumbers(),
                bonusNumber);
        double amountPercent = lottoService.resultSum(WinLottoAmountHistory, count);
        lottoService.finalResult(WinLottoAmountHistory, amountPercent);
    }

    private Lotto[] generateMyLotto(LottoService lottoService, int count) {
        Lotto[] myLotto = new Lotto[count];
        for (int i = 0; i < count; i++) {
            myLotto[i] = lottoService.pickLottoNumber();
            Output.buyLottoPrint(myLotto[i].getNumbers(), count);
        }
        return myLotto;
    }
}
