package lotto;

import lotto.service.InputService;
import lotto.service.LottoService;
import lotto.service.OutputService;
import lotto.service.Separator;

import java.util.List;

public class Application {
    private static final int TICKET_PRICE = 1000;
    private static final InputService inputService = new InputService();
    private static final OutputService outputService = new OutputService();
    private static final Separator separator = new Separator();
    private static final LottoService lottoService = new LottoService();

    public static void main(String[] args) {
        int purchaseAmount = inputService.inputPurchaseAmount(TICKET_PRICE);
        int purchaseCount = purchaseAmount / TICKET_PRICE;
        System.out.println();

        System.out.println(purchaseCount + "개를 구매했습니다.");
        List<Lotto> lottos = lottoService.createLotto(purchaseCount);
        outputService.printLottos(lottos);

        String winningNumbers = inputService.inputWinningNumbers();
        List<Integer> separatedNumbers = separator.separate(winningNumbers);

        int bonusNumber = inputService.inputBonusNumber();
    }
}
