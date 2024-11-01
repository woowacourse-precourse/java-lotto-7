package lotto.controller;

import static lotto.view.OutputView.printLottoExceptionMessage;
import static lotto.view.OutputView.printLottoGroup;
import static lotto.view.OutputView.printNewLine;
import static lotto.view.OutputView.printPurchaseMessage;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningNumbers;
import lotto.exception.LottoException;
import lotto.service.BuyerService;
import lotto.service.LottoService;
import lotto.view.InputView;

public class LottoGameController {
    private final BuyerService buyerService;
    private final LottoService lottoService;

    public LottoGameController(BuyerService buyerService, LottoService lottoService) {
        this.buyerService = buyerService;
        this.lottoService = lottoService;
    }

    public void run() {
        final int lottoQuantity = getLottoQuantity();
        final Lottos lottos = getLottos(lottoQuantity);
        final WinningNumbers winningNumbers = getWinningNumbers();
        final BonusNumber bonusNumber = getBonusNumber(winningNumbers);
    }

    private int getLottoQuantity() {
        String input = InputView.inputPurchaseAmount();

        try {
            int lottoQuantity = buyerService.calculateLottoQuantity(input);
            printPurchaseMessage(lottoQuantity);

            return lottoQuantity;
        } catch (LottoException e) {
            printLottoExceptionMessage(e);

            return getLottoQuantity();
        }
    }

    private Lottos getLottos(int lottoQuantity) {
        Lottos lottos = lottoService.createLottos(lottoQuantity);
        List<Lotto> lottoGroup = lottoService.convertToLottoGroup(lottos);

        printLottoGroup(lottoGroup);

        return lottos;
    }

    private WinningNumbers getWinningNumbers() {
        String input = InputView.inputWinningNumbers();

        try {
            WinningNumbers winningNumbers = buyerService.createWinningNumbers(input);
            printNewLine();

            return winningNumbers;
        } catch (LottoException e) {
            printLottoExceptionMessage(e);

            return getWinningNumbers();
        }
    }

    private BonusNumber getBonusNumber(WinningNumbers winningNumbers) {
        String input = InputView.inputBonusNumbers();

        try {
            BonusNumber bonusNumber =  buyerService.createBonusNumber(winningNumbers, input);
            printNewLine();

            return bonusNumber;
        } catch (LottoException e) {
            printLottoExceptionMessage(e);

            return getBonusNumber(winningNumbers);
        }
    }
}
