package lotto;

import static lotto.controller.lottoController.totalCount;
import static lotto.model.lottoDraw.drawLottos;
import static lotto.view.output.printBoughtLottos;

import java.util.List;
import lotto.controller.lottoController;
import lotto.model.Lotto;
import lotto.model.WinningLotto;

public class Application {
    public static void main(String[] args) {
        int totalCount = totalCount();
        List<Lotto> lottos = drawLottos(totalCount);
        printBoughtLottos(totalCount, lottos);
        WinningLotto winningLotto = lottoController.winningLotto();
        lottoController.bonusNumber(winningLotto);
//        getSummary(lottos, winningLotto, bonusNumber);
    }
}
