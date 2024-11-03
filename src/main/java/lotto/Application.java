package lotto;


import lotto.prompt.LottoDrawPrompt;
import lotto.prompt.LottoPurchasePrompt;
import lotto.service.LottoMachine;

public class Application {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine();

        lottoMachine.purchase(new LottoPurchasePrompt());
        lottoMachine.draw(new LottoDrawPrompt());
    }
}
