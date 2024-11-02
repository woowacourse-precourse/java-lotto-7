package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.Factory.LottoFactory;
import lotto.Factory.LottoGeneratorFactory;
import lotto.Factory.ResultCalculatorFactory;
import lotto.Factory.ResultGeneratorFactory;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.service.LottoGenerator;
import lotto.service.Payment;
import lotto.service.ResultCalculator;
import lotto.service.ResultGenerator;
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
