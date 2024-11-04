package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.lottoNumber.RandomNumberGenerator;
import lotto.service.LottoService;
import lotto.view.InputHandler;
import lotto.view.OutputHandler;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();
        LottoService lottoService = new LottoService();

        int lottoCount = inputHandler.getNumberOfLottoTickets();
        List<Lotto> purchasedLottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            purchasedLottos.add(new Lotto(RandomNumberGenerator.generateRandomNumbers()));
        }

        outputHandler.printPurchasedLotto(purchasedLottos);

        List<Integer> winningNumbers = inputHandler.getWinningNumbers();
        int bonusNumber = inputHandler.getBonusNumber();

        LottoResult result = lottoService.calculateResult(purchasedLottos, winningNumbers, bonusNumber);
        result.printStatistics();
        System.out.printf("총 수익률은 %.1f%%입니다.\n", result.calculateEarningsRate(lottoCount * 1000));

    }
}
