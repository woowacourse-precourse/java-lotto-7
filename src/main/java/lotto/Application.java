package lotto;

import lotto.app.CLILottoApp;
import lotto.app.LottoApp;

public class Application {
    public static void main(String[] args) {
        LottoApp app = new CLILottoApp();
        app.run();
    }
}
