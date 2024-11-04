package lotto;

import lotto.service.InputService;
import lotto.service.LottoService;
import lotto.service.Separator;

import java.util.List;

public class Application {
    private static final int TICKET_PRICE = 1000;
    private static final InputService inputService = new InputService();
    private static final Separator separator = new Separator();
    private static final LottoService lottoService = new LottoService();

    public static void main(String[] args) {
        int purchaseAmount = inputService.inputPurchaseAmount(TICKET_PRICE);
        int purchaseCount = purchaseAmount / TICKET_PRICE;

        String winningNumbers = inputService.inputWinningNumbers();
        List<Integer> separatedNumbers = separator.separate(winningNumbers);

        List<Lotto> lottos = lottoService.createLotto(purchaseCount);

        int bonusNumber = inputService.inputBonusNumber();
    }
}
