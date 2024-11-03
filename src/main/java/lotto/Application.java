package lotto;

import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        DependencyConfig dependencyConfig = new DependencyConfig();
        LottoController lottoController = dependencyConfig.lottoController();
        lottoController.run();
    }
}
