package lotto.controller;

import lotto.customer.Customer;
import lotto.model.Lotto;
import lotto.model.LottoGame;
import lotto.model.LottoMachine;
import lotto.model.LottoResult;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private LottoMachine lottoMachine;
    private Customer customer;
    private InputView inputView;
    private OutputView outputView;
    private LottoGame lottoGame;

    public LottoController(InputView inputView, OutputView outputView, LottoMachine lottoMachine){
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoMachine = lottoMachine;
    }
    private void initializeCustomer() {
        customer = new Customer(inputView.readPayAmount());
    }
    private void initializeLottoGame() {
        List<Integer> goldenNumbers = inputView.readGoldenNumbers();
        lottoGame = new LottoGame(goldenNumbers, inputView.readBonusNumber(goldenNumbers));
    }
    public void run() {
        initializeCustomer();
        List<Lotto> all_lottos = lottoMachine.publishLotteries(customer.getPayAmount());
        outputView.showPurchasedLotteries(all_lottos);
        initializeLottoGame();
        LottoResult result = lottoGame.calculateResult(all_lottos);
        outputView.showResult(result, customer.getPayAmount());
    }
}
