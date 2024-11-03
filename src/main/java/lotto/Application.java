package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.LottoController;
import lotto.view.InputReader;
import lotto.view.OutputWriter;

public class Application {
    public static void main(String[] args) {
        InputReader reader = new InputReader();
        OutputWriter writer = new OutputWriter();
        LottoController lottoController = new LottoController(reader, writer);
        lottoController.buy();

        Console.close();
    }
}
