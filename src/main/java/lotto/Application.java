package lotto;

import lotto.container.DependencyInjectionContainer;
import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        DependencyInjectionContainer container = new DependencyInjectionContainer();
        LottoController lottoController = container.get(LottoController.class);
        lottoController.purchaseLotto();
    }
}
