package lotto;

import lotto.controller.LottoSimulatorController;

public class Application {
    public static void main(String[] args) {
        LottoSimulatorController lottoSimulatorController = new LottoSimulatorController();
        lottoSimulatorController.run();
    }
}
