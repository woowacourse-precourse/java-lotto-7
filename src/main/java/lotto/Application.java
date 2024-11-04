package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.LottoController;
import lotto.view.LottoView;

public class Application {
    public static void main(String[] args) {
        LottoView lottoView = new LottoView(Console::readLine, System.out::println);
        LottoController lottoController = new LottoController(lottoView);
        lottoController.run();
    }
}
