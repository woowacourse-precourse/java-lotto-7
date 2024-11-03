package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.service.generator.LottoGenerator;
import lotto.service.Payment;
import lotto.service.calculator.ResultCalculator;
import lotto.service.generator.ResultGenerator;
import lotto.util.ProfitCalculator;
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

    public void showWinningResult(Lotto winning, Bonus bonus) {
        ResultGenerator resultGenerator = ResultGenerator.create(lottoTicket, winning, bonus);

        outputView.printlnMessage(PrintMessage.LOTTO_WINNING_RESULT_MESSAGE);
        ResultCalculator resultCalculator = ResultCalculator.create(resultGenerator.getWinningResult(), resultGenerator.getBonusResult());
        outputView.printWinningDetail(resultCalculator.getDetail());

        outputView.printProfitRate(ProfitCalculator.calculate(payment, resultCalculator.getPrizeMoney()));
    }
}
