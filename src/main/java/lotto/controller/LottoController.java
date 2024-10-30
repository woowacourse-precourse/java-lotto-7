package lotto.controller;

import lotto.model.Lotto;
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
        getRandomLottosAndPrint(lottoCount);
    }

    private Integer getLottoCount() {
        outputView.printMessage("구입금액을 입력해 주세요.");
        return inputView.inputPrice();
    }

    private List<Lotto> getRandomLottosAndPrint(Integer lottoCount) {
        outputView.printMessage(lottoCount + "개를 구매했습니다.");
        List<Lotto> lottos = createLottos(lottoCount);
        lottos.forEach(outputView::printLottoNumbers);
        return lottos;
    }

    private List<Lotto> createLottos(Integer lottoCount) {
        return Stream.generate(lottoService::createLotto)
                .limit(lottoCount)
                .toList();
    }
}
