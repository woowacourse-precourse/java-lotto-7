package lotto.controller;

import lotto.constants.value.LottoRule;
import lotto.domain.LottoMachine;
import lotto.view.OutputView;

import java.util.function.Supplier;

public class LottoController {

    private final LottoInputManger inputManger;
    private final LottoMachine lottoMachine;
    private final OutputView outputView;

    public LottoController(LottoInputManger inputManger, LottoMachine lottoMachine, OutputView outputView) {
        this.inputManger = inputManger;
        this.lottoMachine = lottoMachine;
        this.outputView = outputView;
    }

    public void play(){
        int inputPrice = ErrorCatcher(inputManger::getInputPrice);
        int lottoBuyAmount = inputPrice/ LottoRule.LOTTO_PRICE.getInstance();

    }


    private <T> T ErrorCatcher(Supplier<T> function) {
        while (true) {
            try {
                return function.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
