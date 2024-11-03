package lotto;


import lotto.controller.LottoMachine;
import lotto.prompt.LottoDrawPrompt;
import lotto.prompt.LottoPurchasePrompt;

public class Application {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.purchase(new LottoPurchasePrompt());
        lottoMachine.draw(new LottoDrawPrompt());
    }
}
