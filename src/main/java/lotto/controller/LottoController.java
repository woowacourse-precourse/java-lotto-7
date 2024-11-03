package lotto.controller;

import lotto.service.LottoServiceImpl;

public class LottoController {
    private static LottoController lottoController;
    private static LottoServiceImpl lottoService = LottoServiceImpl.getInstance();

    public static LottoController getInstance() {
        if (lottoController == null) {
            lottoController = new LottoController();
        }
        return lottoController;
    }

    public void buyLotto(Integer lottoCount) {
        lottoService.buyLotto(lottoCount);
    }
}
