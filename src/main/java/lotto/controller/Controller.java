package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.LottoService;

public class Controller {

    private final LottoService lottoService = new LottoService();

    public void run() {
        int money = lottoService.getMoney();

        // 테스트용
        System.out.println("받은 돈: " + money);
        Lotto testLotto = LottoGenerator.createLotto();

        // 로또 생성 테스트
        for (int num : testLotto.getNumbers()) {
            System.out.print(num + " ");
        }
    }
}
