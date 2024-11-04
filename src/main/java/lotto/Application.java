package lotto;

import lotto.InputView;
import lotto.ResultView;
import lotto.Lotto;
import lotto.LottoGenerator;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            int purchaseAmount = InputView.readPurchaseAmount();
            int lottoCount = purchaseAmount / 1000;
            List<Lotto> lottos = LottoGenerator.generateLottos(lottoCount);
            ResultView.printLottos(lottos);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}