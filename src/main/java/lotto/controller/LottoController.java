package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.factory.LottoGeneratorFactory;
import lotto.factory.ResultCalculatorFactory;
import lotto.factory.ResultGeneratorFactory;
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

    public void showLottoDetail(Payment payment) {
        outputView.printlnMessage(PrintMessage.LINE_SPACE);

        Integer lottoCount = payment.getLottoCount();
        outputView.printBuyResult(lottoCount);

        LottoGenerator lottoGenerator = LottoGeneratorFactory.create(lottoCount);
        lottoTicket = lottoGenerator.getLottoTicket();
        outputView.printLotto(lottoTicket);
    }

    public void showLottoWinningResult(Lotto winning, Bonus bonus) {
        ResultGenerator resultGenerator = ResultGeneratorFactory.create(lottoTicket, winning, bonus); //수정 필요

        outputView.printlnMessage(PrintMessage.LINE_SPACE);
        outputView.printlnMessage(PrintMessage.LOTTO_WINNING_RESULT_MESSAGE);
        ResultCalculator resultCalculator = ResultCalculatorFactory.create(
                resultGenerator.getWinningResult(),
                resultGenerator.getBonusResult());
        outputView.printWinningDetail(resultCalculator.getDetail());
    }
}
