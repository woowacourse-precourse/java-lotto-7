package lotto.controller;

import lotto.model.InputService;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private final InputService inputService;
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoResult lottoResult;

    public LottoController(InputService inputService, InputView inputView, OutputView outputView, LottoResult lottoResult) {
        this.inputService = inputService;
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoResult = lottoResult;
    }

    public void run(){
        try{
            start();
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
    }

    public void start(){
        inputView.printPurchase();
        int purchase = inputService.purchaseValue();

        int ticket = purchase / 1000;
        inputView.printPurchaseCount(ticket);
        List<Lotto> lottos = inputService.lottoNumbersValue(ticket);

        inputView.printPlaceNumber();
        List<Integer> winningNumbers = inputService.winningNumbersValue();

        inputView.printBonusNumber();
        int bonusNumber = inputService.bonusNumberValue();

        LottoResult winning = lottoResult.winning(lottos, winningNumbers, bonusNumber);
        outputView.printResult(winning, lottoResult.getProfitRate(purchase));
    }
}
