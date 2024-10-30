package lotto.controller;

import lotto.model.Game;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.stream.Stream;

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
    }


    private Integer getLottoCount() {
        outputView.printMessage("구입금액을 입력해 주세요.");
        return inputView.inputPrice();
    }

    private List<Lotto> createRandomLottosAndPrint(Integer lottoCount) {
        outputView.printMessage(lottoCount + "개를 구매했습니다.");
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
        return new Game(lottos, winningNumbers, bonusNumbers);
    }

    private List<Integer> getWinningNumbers() {
        outputView.printMessage("당첨 번호를 입력해 주세요.");
        return inputView.inputWinningNumbers();
    }

    private Integer getBonusNumber() {
        outputView.printMessage("보너스 번호를 입력해 주세요.");
        return inputView.inputBonusNumber();
    }
}
