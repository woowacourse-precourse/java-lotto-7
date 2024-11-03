package lotto.controller;

import lotto.repository.LottoRepository;

public class MainController {
    private static ViewControllerImpl viewController = ViewControllerImpl.getInstance();
    private static LottoController lottoController = LottoController.getInstance();

    public static void run(){
        Integer lottoCount = viewController.getMoney();
        lottoController.buyLotto(lottoCount);
    }
}
