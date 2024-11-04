package lotto;

import lotto.controller.LottoController;
import lotto.entity.Lottos;
import lotto.view.LottoOutput;

public class Application {
    public static void main(String[] args) {
        Lottos lottos = new Lottos();
        LottoOutput output = new LottoOutput();
        LottoController controller = new LottoController(lottos, output);

        controller.startLotto();
    }
}
