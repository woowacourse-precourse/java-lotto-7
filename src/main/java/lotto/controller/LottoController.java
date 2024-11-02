package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.service.generator.LottoGenerator;
import lotto.service.Payment;
import lotto.service.calculator.ResultCalculator;
import lotto.service.generator.ResultGenerator;
import lotto.view.OutputView;
import lotto.view.PrintMessage;

public class LottoController {

    private final OutputView outputView;
    private List<Lotto> lottoTicket = new ArrayList<>();

    public LottoController(OutputView outputView) {
        this.outputView = outputView;
    }

    public void showTicket(Payment payment) {
        Integer lottoCount = payment.getLottoCount();
        outputView.printBuyResult(lottoCount);

        LottoGenerator lottoGenerator = LottoGenerator.create(lottoCount);
        lottoTicket = lottoGenerator.getLottoTicket();
        outputView.printLottoTicket(lottoTicket);
        outputView.printlnMessage(PrintMessage.LINE_SPACE);
    }

    public void showWinningResult(Lotto winning, Bonus bonus) {
        ResultGenerator resultGenerator = ResultGenerator.create(lottoTicket, winning, bonus); //수정 필요

        outputView.printlnMessage(PrintMessage.LOTTO_WINNING_RESULT_MESSAGE);
        ResultCalculator resultCalculator = ResultCalculator.create(
                resultGenerator.getWinningResult(),
                resultGenerator.getBonusResult());
        outputView.printWinningDetail(resultCalculator.getDetail());
        outputView.printlnMessage(PrintMessage.LINE_SPACE);
    }
}
