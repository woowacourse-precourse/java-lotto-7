package lotto.controller;

import lotto.model.LottoService;

public class Controller {

    private final LottoService lottoService = new LottoService();

    public void run() {
        int money = lottoService.getMoney();

        // 테스트용
        System.out.println("받은 돈: " + money);
    }
}
