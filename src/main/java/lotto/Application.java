package lotto;

import lotto.Controller.LottoController;

public class Application {
    private static final String ERROR_MESSAGE = "[ERROR] ";

    public static void main(String[] args) {
        LottoController lottoController=new LottoController();
        lottoController.run();
    }
}
