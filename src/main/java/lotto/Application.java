package lotto;

import java.math.BigDecimal;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        BigDecimal amount = inputView.readPurchaseAmount();
        LottoMachine lottoMachine = new LottoMachine();
        int lottoCount = lottoMachine.calculateNumberOfTickets(amount);
        List<Lotto> lottos = lottoMachine.generateLottoTickets(lottoCount);
        OutputView outputView = new OutputView();
        outputView.printLottoTickets(lottos);
        List<Integer> winningNumbers = inputView.readWinningNumbers();
        int bonusNumber = inputView.readBonusNumber(winningNumbers);
        Result result = lottoMachine.evaluateLottoTickets(lottos, winningNumbers, bonusNumber);
        outputView.printResult(result, amount);
    }
}
