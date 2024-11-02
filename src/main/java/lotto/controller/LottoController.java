package lotto.controller;

import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.view.InputView;

public class LottoController {

    // Todo
    // 로또 당첨 확인
    // 로또 당첨 통계
    // 로또 수익률 계산

    private final InputView inputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, LottoService lottoService) {
        this.inputView = inputView;
        this.lottoService = lottoService;
    }

    public void buyLotto() {
        String money = inputView.inputMoney();
        lottoService.buyLotto(money);

        for (Lotto lotto : lottoService.getAllLottos()) {
            System.out.println("lotto = " + lotto);
        }
    }

    public void checkLotto() {
        String winnerNumbers = inputView.inputWinnerNumbers();
        String bonusNumber = inputView.inputBonusNumber();
        lottoService.checkLotto(winnerNumbers, bonusNumber);
    }

    public void startLottoGame() {
        
         buyLotto();
         checkLotto();
    }
}
