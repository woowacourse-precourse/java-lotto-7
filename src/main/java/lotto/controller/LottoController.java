package lotto.controller;

import java.util.EnumMap;
import lotto.domain.Lotto;
import lotto.domain.WinAmount;
import lotto.service.LottoService;
import lotto.view.Output;

public class LottoController {
    public void run() {
        LottoService lottoService = new LottoService();

        int count = lottoService.buyLotto(); // 로또 구매

        Lotto[] lottos = new Lotto[count];
        for (int i = 0; i < count; i++) { // n번 만큼 로또 번호 추첨
            lottos[i] = lottoService.pickLottoNumber();
            Output.buyLottoPrint(lottos[i].getNumbers(), count);
        }

        Lotto winNumbers = lottoService.setWinNumber(); // 당첨 번호 입력
        int bonusNumber = lottoService.setBonusNumber(winNumbers); // 보너스 번호

        EnumMap<WinAmount, Integer> WinLottoAmountHistory = lottoService.comPareMyLotto_WinLotto(lottos,
                winNumbers.getNumbers(), bonusNumber);
        double amountPercent = lottoService.resultSum(WinLottoAmountHistory, count);
        lottoService.finalResult(WinLottoAmountHistory, amountPercent);


    }
}
