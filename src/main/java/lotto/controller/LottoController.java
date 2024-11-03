package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.service.generator.LottoGenerator;
import lotto.service.Payment;
import lotto.view.OutputView;
import lotto.message.PrintMessage;

public class LottoController {

    private final OutputView outputView;
    private List<Lotto> lottoTicket = new ArrayList<>();
    private final Payment payment;

    public LottoController(OutputView outputView, Payment payment) {
        this.outputView = outputView;
        this.payment = payment;
    }

    public void showTicket() {
        Integer lottoCount = payment.getLottoCount();
        outputView.printBuyResult(lottoCount);

        LottoGenerator lottoGenerator = LottoGenerator.create(lottoCount);
        lottoTicket = lottoGenerator.getLottoTicket();
        outputView.printLottoTicket(lottoTicket);
        outputView.printlnMessage(PrintMessage.LINE_SPACE);
    }

    public List<Lotto> getLottoTicket() {
        return lottoTicket;
    }
}
