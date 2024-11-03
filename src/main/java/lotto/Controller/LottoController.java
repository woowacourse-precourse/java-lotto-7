package lotto.Controller;

import java.util.List;
import lotto.Input.InputView;
import lotto.Output.OutputView;
import lotto.Service.LottoService;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLottoNumbers;
import lotto.domain.WinningNumbers;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        PurchaseAmount purchaseAmount = purchaseLottos();
        List<Lotto> lottos = generateLottos(purchaseAmount);
        outputView.printLottos(lottos);

        WinningNumbers winningNumbers = createWinningNumbers();
        LottoResult result = LottoResult.of(lottos, winningNumbers);
        outputView.printWinningStatistics(result);
    }

    private List<Lotto> generateLottos(PurchaseAmount purchaseAmount) {
        return lottoService.generateLottos(purchaseAmount.getAmount());
    }

    private PurchaseAmount purchaseLottos() {
        while (true) {
            try {
                String input = inputView.readPurchaseAmount();
                return PurchaseAmount.from(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private WinningNumbers createWinningNumbers() {
        WinningLottoNumbers winningNumbers = createWinningLottoNumbers();
        BonusNumber bonusNumber = createBonusNumber();
        return new WinningNumbers(winningNumbers, bonusNumber);
    }

    private WinningLottoNumbers createWinningLottoNumbers() {
        while (true) {
            try {
                String input = inputView.readWinningNumbers();
                return WinningLottoNumbers.from(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private BonusNumber createBonusNumber() {
        while (true) {
            try {
                String input = inputView.readBonusNumber();
                return BonusNumber.from(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
