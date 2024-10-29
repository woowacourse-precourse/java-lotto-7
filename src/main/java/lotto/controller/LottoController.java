package lotto.controller;


import java.util.List;
import java.util.Map;
import java.util.Set;
import lotto.LottoMachine;
import lotto.domain.Lotto;
import lotto.domain.LottoTickets;
import lotto.generator.Generator;
import lotto.generator.RandomGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Generator generator = new RandomGenerator();

    public void run() {
        int purchaseAmount = getPurchaseAmount();

        LottoTickets lottoTickets = issueLottoTickets(purchaseAmount);

        outputView.showWinningNumbersInputMessage();
        Set<Integer> winningNumbers = inputView.inputWinningNumbers();

        outputView.showBonusNumberInputMessage();
        int bonusNumber = inputView.inputBonusNumber();

        Map<Integer, Integer> rankMap = lottoTickets.matchNumbers(winningNumbers, bonusNumber);
        outputView.showResult(rankMap);

        Long total = 0L;
        total += rankMap.get(1) * 2000000000;
        total += rankMap.get(2) * 30000000;
        total += rankMap.get(3) * 1500000;
        total += rankMap.get(4) * 50000;
        total += rankMap.get(5) * 5000;

        outputView.showRateOfReturn(total, purchaseAmount);
    }

    private LottoTickets issueLottoTickets(int purchaseAmount) {
        LottoMachine lottoMachine = new LottoMachine(generator);
        LottoTickets lottoTickets = lottoMachine.getLottoTickets(purchaseAmount);
        outputView.showLottoCountAndNumbers(lottoTickets);
        return lottoTickets;
    }

    private int getPurchaseAmount() {
        outputView.showPurchaseAmountInputMessage();
        return inputView.inputPurchaseAmount();
    }
}
