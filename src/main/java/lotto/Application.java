package lotto;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        List<Lotto> lottos = LottoInputManager.inputPrice();
        WinningLotto winningLotto = LottoInputManager.inputWinningLotto();
        LottoResult result = new LottoResult(lottos, winningLotto);
        System.out.println("당첨 통계\n---");
        result.printResult();

    }
}
