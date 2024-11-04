package lotto.controller;

import java.util.List;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.message.PrintMessage;
import lotto.service.Payment;
import lotto.service.calculator.BonusCalculator;
import lotto.service.calculator.ResultCalculator;
import lotto.service.calculator.WinningCalculator;
import lotto.service.printer.ResultPrinter;
import lotto.util.PrizeMoneyCalculator;
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
        WinningCalculator resultGenerator = WinningCalculator.create(lottoTicket, winning);
        BonusCalculator bonusCalculator = BonusCalculator.create(lottoTicket, bonus);

        outputView.printlnMessage(PrintMessage.LOTTO_WINNING_RESULT_MESSAGE);
        ResultCalculator resultCalculator = ResultCalculator.create(resultGenerator.getWinningResult(),
                bonusCalculator.getBonusResult());
        ResultPrinter resultPrinter = ResultPrinter.create(resultCalculator.getPlaces());
        outputView.printWinningDetail(resultPrinter.getDetail());
        outputView.printProfitRate(
                ProfitCalculator.calculate(payment, PrizeMoneyCalculator.getPrizeMoney(resultCalculator.getPlaces())));
    }
}
