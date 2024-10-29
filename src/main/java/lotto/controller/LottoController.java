package lotto.controller;

import lotto.LottoMachine;
import lotto.domain.Lotteries;
import lotto.generator.Generator;
import lotto.generator.RandomGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Generator generator = new RandomGenerator();

    public void run() {
        outputView.showPurchaseInputMessage();
        int purchaseQuantity = inputView.inputPurchaseAmount();
        LottoMachine lottoMachine = new LottoMachine(generator);
        Lotteries lotteries = lottoMachine.getLotteries(purchaseQuantity);


    }
}
