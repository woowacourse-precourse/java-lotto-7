package lotto.controller;

import static lotto.view.InputView.closeConsole;
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
import lotto.dto.WinningStat;
import lotto.dto.WinningSummary;
import lotto.exception.LottoException;
import lotto.service.UserService;
import lotto.service.LottoService;
import lotto.service.StatService;
import lotto.utils.WinningSummaryGenerator;
import lotto.view.InputView;

public class LottoGameController {
    private final UserService userService;
    private final LottoService lottoService;
    private final StatService statService;

    public LottoGameController(UserService userService, LottoService lottoService, StatService statService) {
        this.userService = userService;
        this.lottoService = lottoService;
        this.statService = statService;
    }

    public void run() {
        final LottoGame lottoGame = setLottoGame();
        final WinningSummary winningSummary = getWinningSummary(lottoGame);

        getReturnRate(lottoGame, winningSummary);
    }

    private LottoGame setLottoGame() {
        final Lottos lottos = purchaseLotto();
        final Lotto winningLotto = getWinningLotto();
        final BonusNumber bonusNumber = getBonusNumber(winningLotto);

        closeConsole();

        return lottoService.createLottoGame(lottos, winningLotto, bonusNumber);
    }

    private Lottos purchaseLotto() {
        final int lottoQuantity = getLottoQuantity();
        return getLottos(lottoQuantity);
    }

    private int getLottoQuantity() {
        String input = InputView.inputPurchaseAmount();

        try {
            int lottoQuantity = userService.calculateLottoQuantity(input);
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

    private Lotto getWinningLotto() {
        String input = InputView.inputWinningNumbers();

        try {
            Lotto winningLotto = userService.createWinningLotto(input);
            printNewLine();

            return winningLotto;
        } catch (LottoException e) {
            printLottoExceptionMessage(e);

            return getWinningLotto();
        }
    }

    private BonusNumber getBonusNumber(Lotto winningLotto) {
        String input = InputView.inputBonusNumbers();

        try {
            BonusNumber bonusNumber = userService.createBonusNumber(winningLotto, input);
            printNewLine();

            return bonusNumber;
        } catch (LottoException e) {
            printLottoExceptionMessage(e);

            return getBonusNumber(winningLotto);
        }
    }

    private WinningSummary getWinningSummary(LottoGame lottoGame) {
        printWinningStatsTitle();

        return calculateStats(lottoGame);
    }

    private WinningSummary calculateStats(LottoGame lottoGame) {
        List<WinningStat> winningStats = statService.getWinningStats(lottoGame);
        WinningSummary winningSummary = WinningSummaryGenerator.generate(winningStats);

        printWinningSummary(winningSummary);

        return winningSummary;
    }

    private void getReturnRate(LottoGame lottoGame, WinningSummary winningSummary) {
        Revenue revenue = statService.createRevenue(lottoGame.getLottos(), winningSummary.WinningStats());

        printReturnRate(revenue);
    }

}
