package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.service.LottoGenerator;
import lotto.service.Payment;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.PrintMessage;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void showLottoDetail(Payment payment) {
        outputView.printlnMessage(PrintMessage.LINE_SPACE);

        Integer lottoCount = payment.getLottoCount();
        outputView.printBuyResult(lottoCount);

        LottoGenerator lottoGenerator = new LottoGenerator(lottoCount);
        List<Lotto> lottos = lottoGenerator.getLottoTicket();
        outputView.printLotto(lottos);
    }
}
