package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoGenerator lottoGenerator;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoGenerator = new LottoGenerator();
    }

    public void getStartLotto() {
        try {
            Money money = new Money(inputView.getValue());
            Lottos lottos = lottoGenerator.createLottos(money.getTicket());

            outputView.printBuyLotto(money);
            outputView.printLottos(lottos);


        } catch (IllegalArgumentException e) {
        }
    }

}
