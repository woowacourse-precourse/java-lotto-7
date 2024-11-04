package lotto;

import java.util.List;
import java.util.Map;

public class Application {

    private static final int LOTTO_AMOUNT_UNIT = 1000;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        User user = new User();

        int purchaseAmount = inputView.inputPurchaseAmount();
        List<Lotto> lottos = user.createLotto(purchaseAmount / LOTTO_AMOUNT_UNIT);
        outputView.printLottos(lottos);
        Lotto winningLotto = inputView.inputWinningLottoNumbers();
        int bonusNumber = inputView.inputBonus(winningLotto);
        Map<Rank, Integer> winnings = user.countRank(lottos, winningLotto, bonusNumber);
        double earningRate = user.calculateReturn(winnings, purchaseAmount);
        outputView.printWinningStatistics(winnings, earningRate);

    }


}
