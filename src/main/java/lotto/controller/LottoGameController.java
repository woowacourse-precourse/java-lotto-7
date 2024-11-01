package lotto.controller;

import static lotto.view.OutputView.printLottoExceptionMessage;
import static lotto.view.OutputView.printLottoGroup;
import static lotto.view.OutputView.printNewLine;
import static lotto.view.OutputView.printPurchaseMessage;
import static lotto.view.OutputView.printReturnRate;
import static lotto.view.OutputView.printWinningStatsTitle;
import static lotto.view.OutputView.printWinningSummary;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.Lottos;
import lotto.domain.Revenue;
import lotto.domain.WinningNumbers;
import lotto.dto.WinningStat;
import lotto.exception.LottoException;
import lotto.service.BuyerService;
import lotto.service.LottoService;
import lotto.service.StatService;
import lotto.utils.WinningSummaryGenerator;
import lotto.view.InputView;

public class LottoGameController {
    private final BuyerService buyerService;
    private final LottoService lottoService;
    private final StatService statService;

    public LottoGameController(BuyerService buyerService, LottoService lottoService, StatService statService) {
        this.buyerService = buyerService;
        this.lottoService = lottoService;
        this.statService = statService;
    }

    public void run() {
        final int lottoQuantity = getLottoQuantity();
        final Lottos lottos = getLottos(lottoQuantity);
        final WinningNumbers winningNumbers = getWinningNumbers();
        final BonusNumber bonusNumber = getBonusNumber(winningNumbers);
        final LottoGame lottoGame = getLottoGame(lottos, winningNumbers, bonusNumber);
        getWinningSummary(lottoQuantity, lottoGame);
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
        List<Lotto> lottoGroup = lottos.getLottoGroup();

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

    private LottoGame getLottoGame(Lottos lottos, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        return lottoService.createLottoGame(lottos, winningNumbers, bonusNumber);
    }

    private void getWinningSummary(int lottoQuantity, LottoGame lottoGame) {
        printWinningStatsTitle();

        List<WinningStat> winningStats = statService.getWinningStats(lottoGame);

        printWinningSummary(WinningSummaryGenerator.generate(winningStats));

        Revenue revenue = statService.createRevenue(lottoQuantity, winningStats);

        printReturnRate(revenue);
    }
}
