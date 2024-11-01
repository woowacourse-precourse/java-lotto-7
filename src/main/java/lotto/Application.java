package lotto;

import lotto.controller.LottoController;
import lotto.view.LottoPolicy;
import lotto.view.Policy;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Policy policy = new LottoPolicy();
        LottoController lottoController = LottoController.newDefaultInstance(policy);
        lottoController.run();
    }
}
