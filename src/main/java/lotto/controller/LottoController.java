package lotto.controller;

import lotto.service.LottoService;
import lotto.view.InputView;

import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final LottoService lottoService;

    public LottoController() {
        this.inputView = new InputView();
        this.lottoService = new LottoService();
    }

    public void start() {
        int payment = inputView.payAmount();
        lottoService.buyLotto(payment);

        List<Integer> prizeNumbers = inputView.prizeNumbers();
        int bonusNumber = inputView.bonusNumber();
        //당첨 번호와 보너스 번호 객체 생성 및 저장
        lottoService.updateWinningNumber(prizeNumbers, bonusNumber);
        lottoService.matchLottos();
    }
}
