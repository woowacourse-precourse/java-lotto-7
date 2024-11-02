package lotto.controller;

import lotto.model.Game;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.stream.Stream;

import static lotto.global.enums.PrintMessage.*;

public class LottoController {
    private static final InputView inputView = InputView.getInstance();
    private static final OutputView outputView = OutputView.getInstance();
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        Integer lottoCount = getLottoCount();
        Lottos lottos = new Lottos(createRandomLottosAndPrint(lottoCount));
        Game game = createGame(lottos);
        lottoService.run(game);
    }


    private Integer getLottoCount() {
        outputView.printMessage(INPUT_PRICE);
        try {
            return inputView.inputPrice();
        } catch (IllegalArgumentException e) {
            outputView.printMessage(e.getMessage());
            return getLottoCount();
        }
    }

    private List<Lotto> createRandomLottosAndPrint(Integer lottoCount) {
        outputView.printMessage(outputView.formattingMessage(LOTTO_COUNT, lottoCount));
        List<Lotto> createdLottos = createLotto(lottoCount);
        createdLottos.forEach(outputView::printLottoNumbers);
        return createdLottos;
    }

    private List<Lotto> createLotto(Integer lottoCount) {
        return Stream.generate(lottoService::createLotto)
                .limit(lottoCount)
                .toList();
    }

    private Game createGame(Lottos lottos) {
        List<Integer> winningNumbers = getWinningNumbers();
        Integer bonusNumbers = getBonusNumber();
        try {
            return new Game(lottos, winningNumbers, bonusNumbers);
        } catch (IllegalArgumentException e) {
            outputView.printMessage(e.getMessage());
            return createGame(lottos);
        }
    }

    private List<Integer> getWinningNumbers() {
        outputView.printMessage(WINNING_NUMBRES);
        try {
            return inputView.inputWinningNumbers();
        } catch (IllegalArgumentException e) {
            outputView.printMessage(e.getMessage());
            return getWinningNumbers();
        }
    }

    private Integer getBonusNumber() {
        outputView.printMessage(BONUS_NUMBER);
        try {
            return inputView.inputBonusNumber();
        } catch (IllegalArgumentException e) {
            outputView.printMessage(e.getMessage());
            return getBonusNumber();
        }
    }
}
