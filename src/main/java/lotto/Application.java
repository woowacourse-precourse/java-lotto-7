package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // 1. 구입 금액 입력
        int amount = InputPrice.getAmount();
        System.out.println("price: "+ amount);
        // 2. 로또 발행
        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> lottos = lottoMachine.buyLottos(amount);
        OutputView.displayLottos(lottos);
    }
}
