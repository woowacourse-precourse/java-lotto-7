package lotto.Controller;

import lotto.Model.Lotto;
import lotto.Model.LottoGenerator;
import lotto.View.InputView;
import lotto.View.OutputView;

import java.util.List;

public class LottoController {

    public void lottoController() {
        int price = InputView.priceInput();

        LottoGenerator generator = new LottoGenerator();
        List<Lotto> allLottos = generator.generateLottos(price);
        OutputView.showLottoCount(allLottos.size());
        OutputView.showAllLottos(allLottos);
    }



}

