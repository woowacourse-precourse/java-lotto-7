package lotto;

import java.util.List;
import java.util.Map;

public class Application {
    private static final LottoService lottoService = new LottoService();
    private static final UserIO userIO = new UserIO();

    public static void main(String[] args) {
        try {
            run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void run() {
        int amount = userIO.readPurchaseAmount();
        List<Lotto> lottos = lottoService.purchaseLottos(amount);
        userIO.printPurchasedLottos(lottos);

        Lotto winningNumbers = userIO.readWinningNumbers();
        int bonusNumber = userIO.readBonusNumber(winningNumbers);

        Map<LottoRank, Integer> result = lottoService.checkWinning(lottos, winningNumbers, bonusNumber);
        double returnRate = lottoService.calculateReturnRate(result, amount);
        userIO.printResults(result, returnRate);
    }
}