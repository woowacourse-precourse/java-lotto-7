package lotto.view;

import lotto.controller.LottoController;

public class LottoView {
    LottoController lottoController = new LottoController();

    public void RunLotto() {
        lottoController.getAmount();
        lottoController.generateLottoNumbers();
        lottoController.saveLottoNumber();
        lottoController.saveBonusNumber();
        lottoController.getResult();
    }
}
