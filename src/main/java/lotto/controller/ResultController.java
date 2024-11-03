package lotto.controller;

import java.util.List;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.factory.ResultCalculatorFactory;
import lotto.factory.ResultGeneratorFactory;
import lotto.message.PrintMessage;
import lotto.service.Payment;
import lotto.service.calculator.ResultCalculator;
import lotto.service.generator.ResultGenerator;
import lotto.util.ProfitCalculator;
import lotto.view.OutputView;

public class ResultController {

    private final OutputView outputView;
    private final List<Lotto> lottoTicket;
    private final Payment payment;

    public ResultController(OutputView outputView, List<Lotto> lottoTicket, Payment payment) {
        this.outputView = outputView;
        this.lottoTicket = lottoTicket;
        this.payment = payment;
    }

    public void showWinning(Lotto winning, Bonus bonus) {
        ResultGenerator resultGenerator = ResultGeneratorFactory.create(lottoTicket, winning, bonus);

        outputView.printlnMessage(PrintMessage.LOTTO_WINNING_RESULT_MESSAGE);
        ResultCalculator resultCalculator = ResultCalculatorFactory.create(resultGenerator.getWinningResult(),
                resultGenerator.getBonusResult());
        outputView.printWinningDetail(resultCalculator.getDetail());

        outputView.printProfitRate(ProfitCalculator.calculate(payment, resultCalculator.getPrizeMoney()));
    }
}
