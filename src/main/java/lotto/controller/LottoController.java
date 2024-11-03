package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.message.PrintMessage;
import lotto.service.Payment;
import lotto.service.generator.LottoGenerator;
import lotto.view.OutputView;

public class LottoController {

    private final OutputView outputView;
    private final Payment payment;
    private List<Lotto> lottoTicket = new ArrayList<>();

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

    public List<Lotto> getTicket() {
        return lottoTicket;
    }
}
